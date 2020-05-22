package com.codejek.account.management.model;

import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Login")
@Validated
public class LoginModel {

	private long id;
	private String username;
	private String password;
	private String oldpwd1;
	private String oldpwd2;
	private String oldpwd3;
	private String pwdHint;
	private long creationTime;
	private long lastModifiedTime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOldpwd1() {
		return oldpwd1;
	}
	public void setOldpwd1(String oldpwd1) {
		this.oldpwd1 = oldpwd1;
	}
	public String getOldpwd2() {
		return oldpwd2;
	}
	public void setOldpwd2(String oldpwd2) {
		this.oldpwd2 = oldpwd2;
	}
	public String getOldpwd3() {
		return oldpwd3;
	}
	public void setOldpwd3(String oldpwd3) {
		this.oldpwd3 = oldpwd3;
	}
	public String getPwdHint() {
		return pwdHint;
	}
	public void setPwdHint(String pwdHint) {
		this.pwdHint = pwdHint;
	}
	public long getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
	}
	public long getLastModifiedTime() {
		return lastModifiedTime;
	}
	public void setLastModifiedTime(long lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
}
