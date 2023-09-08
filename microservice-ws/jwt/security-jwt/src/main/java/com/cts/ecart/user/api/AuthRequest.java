package com.cts.ecart.user.api;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotNull;

public class AuthRequest {
	@NotNull
	@Length(min = 5, max = 50)
	private String userName;

	@NotNull
	@Length(min = 5, max = 10)
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setEmail(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
