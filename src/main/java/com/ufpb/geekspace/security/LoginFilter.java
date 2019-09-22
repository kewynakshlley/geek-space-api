package com.ufpb.geekspace.security;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ufpb.geekspace.dto.LoginDTO;
import com.ufpb.geekspace.util.JsonUtil;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {

	public LoginFilter(String url) {
		super(new AntPathRequestMatcher(url));
		this.setAuthenticationManager(new JwtAuthenticationManager());
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		AccountCredentials credentials = JsonUtil.fromJSon(request.getReader(), AccountCredentials.class);
		return this.getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
				credentials.getEmail(), credentials.getPassword(), Collections.emptyList()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain, Authentication auth) throws IOException, ServletException {

		LoginDTO dto = (LoginDTO) auth.getPrincipal();
		TokenAuthenticationService.addAuthentication(response, dto);
		response.addHeader("Content-Type", "application/json");
		response.getWriter().write(JsonUtil.toJSon(dto));
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	}
}
