package com.codejek.account.management.model;

import org.springframework.validation.annotation.Validated;

import com.codejek.account.management.entity.InventoryCollectionNode;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Seller")
@Validated
public class SellerModel {

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private long phoneNum;
	private long creationTime;
	private long lastModifiedTime;
	private AddressModel addressModel;
	private InventoryCollectionNode inventoryCollectionNode ;
	private LoginModel loginModel;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}
	public InventoryCollectionNode getInventoryCollectionNode() {
		return inventoryCollectionNode;
	}
	public void setInventoryCollectionNode(InventoryCollectionNode inventoryCollectionNode) {
		this.inventoryCollectionNode = inventoryCollectionNode;
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
