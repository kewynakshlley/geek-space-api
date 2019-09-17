package com.ufpb.geekspace.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.ufpb.geekspace.dto.LoginDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {

	static final String SECRET = "descubraapi";
	static final String TOKEN_PREFIX = "Bearer";
	static final String HEADER_STRING = "Authorization";

	static void addAuthentication(HttpServletResponse response, LoginDTO dto) {
		String accessToken = Jwts.builder().setSubject(dto.getLogin()).claim("id", dto.getId())
				.claim("roles", toGrantedAuthorities(dto.getRoles()).toString())
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();

		dto.setAccessToken(accessToken);
	}

	static Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(HEADER_STRING);
		if (token != null) {
			Claims bodyJwt = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
					.getBody();
			String user = bodyJwt.getSubject();
			if (user != null) {
				return new UsernamePasswordAuthenticationToken(user, null,
						getGrantedAuthorities((String) bodyJwt.get("roles")));
			}
		}
		return null;
	}

	static String toGrantedAuthorities(Collection<String> authorities) {
		return authorities.stream().collect(Collectors.joining(","));
	}

	static List<GrantedAuthority> getGrantedAuthorities(String authorities) {
		return authorities.length() == 0 ? new ArrayList<GrantedAuthority>()
				: Arrays.asList(authorities.split(",")).stream().map(item -> new SimpleGrantedAuthority(item))
						.collect(Collectors.toList());
	}
}
