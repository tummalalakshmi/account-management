package com.codejek.account.management.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "User")
@Validated
public class UserModel {
	
	private long id;
	private String firstName;
	private String lastName;
	private long phoneNum;
	private long creationTime;
	private long lastModifiedTime;
	private List<AddressModel> addressModels;
	private LoginModel loginModel;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
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
	public List<AddressModel> getAddressModels() {
		return addressModels;
	}
	public void setAddressModels(List<AddressModel> addressModels) {
		this.addressModels = addressModels;
	}
	public LoginModel getLoginModel() {
		return loginModel;
	}
	public void setLoginModel(LoginModel loginModel) {
		this.loginModel = loginModel;
	}
}
