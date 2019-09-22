package com.ufpb.geekspace.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractRole {

	private String codeName;

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

}
