package com.ufpb.geekspace.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.ufpb.geekspace.config.AppContext;
import com.ufpb.geekspace.dto.LoginDTO;
import com.ufpb.geekspace.model.Administrator;
import com.ufpb.geekspace.repository.AdministratorRepository;

public class JwtAuthenticationManager implements AuthenticationManager {
	private AdministratorRepository administratorRepository;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		Administrator user = this.getAdministratorRepository().findByEmailAndPassword(auth.getName(), (String) auth.getCredentials());
		if(user != null) {
			return new UsernamePasswordAuthenticationToken(toDTO(user), auth.getCredentials());
		}
		
		throw new BadCredentialsException("User and/or password are invalids.");
	}

	
	private LoginDTO toDTO(Administrator user) {
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setLogin(user.getEmail());
		loginDTO.setId(user.getId());
		return loginDTO;
	}
	
	protected AdministratorRepository getAdministratorRepository() {

        if (this.administratorRepository == null) {
            this.administratorRepository = AppContext.getBean(AdministratorRepository.class);
        }

        return this.administratorRepository;
    }

}