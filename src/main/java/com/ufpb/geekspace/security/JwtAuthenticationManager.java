package com.ufpb.geekspace.security;

import java.util.stream.Collectors;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.ufpb.geekspace.config.AppContext;
import com.ufpb.geekspace.dto.LoginDTO;
import com.ufpb.geekspace.model.AbstractPerson;
import com.ufpb.geekspace.model.Client;
import com.ufpb.geekspace.repository.ClientRepository;

public class JwtAuthenticationManager implements AuthenticationManager {
	private ClientRepository clientRepository;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		Client user = this.getClientRepository().findByEmailAndPassword(auth.getName(), (String) auth.getCredentials());
		if(user != null) {
			return new UsernamePasswordAuthenticationToken(toDTO(user), auth.getCredentials());
		}
		
		throw new BadCredentialsException("User and/or password are invalids.");
	}

	
	private LoginDTO toDTO(AbstractPerson user) {
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setLogin(user.getEmail());
		loginDTO.setRoles(user.getRole().stream().map(item -> "ROLE_" + item.getCodeName()).collect(Collectors.toList()));
		return loginDTO;
	}
	
	protected ClientRepository getClientRepository() {

        if (this.clientRepository == null) {
            this.clientRepository = AppContext.getBean(ClientRepository.class);
        }

        return this.clientRepository;
    }

}