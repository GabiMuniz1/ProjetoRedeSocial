package com.redesocial.RedeSocial.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 
 * @author Lauro
 * @since 1.0
 *
 */

public class UserLoginDTO {

	private @NotBlank(message = "Insert valid email") @Email String email;

	private @NotBlank(message = "Insert valid passWord") @Size(min = 3, max = 15) String password;
	
	private String basicToken;
	
	private String name;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passWord) {
		this.password = passWord;
	}

	public String getBasicToken() {
		return basicToken;
	}

	public void setBasicToken(String basicToken) {
		this.basicToken = basicToken;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
