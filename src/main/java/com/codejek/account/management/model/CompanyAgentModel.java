package com.codejek.account.management.model;

import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "CompanyAgent")
@Validated
public class CompanyAgentModel {

	private long id;
	private String firstName;
	private String lastName;
	private AddressModel addressModel;
	private long phoneNum;
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
	public AddressModel getAddressModel() {
		return addressModel;
	}
	public void setAddressModel(AddressModel addressModel) {
		this.addressModel = addressModel;
	}
	public LoginModel getLoginModel() {
		return loginModel;
	}
	public void setLoginModel(LoginModel loginModel) {
		this.loginModel = loginModel;
	}
	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}
}
