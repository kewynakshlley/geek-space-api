package com.ufpb.geekspace.dto;

import java.util.ArrayList;
import java.util.List;

public class LoginDTO {
	private Long administrator_id;
	private Long id;
	
	private String login;
	
	private String accessToken;
	
	private List<String> roles = new ArrayList<String>();

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	public LoginDTO() { }

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Long getAdministrator_id() {
		return administrator_id;
	}

	public void setAdministrator_id(long i) {
		this.administrator_id = i;
	}
	
	
	
}
