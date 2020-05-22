package com.codejek.account.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

import lombok.Data;

@Entity
@Table(name="seller")
@Data
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class SellerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "seller_id", updatable = false, nullable = false)
	@JsonIgnore
	private long id;
	private String name;
	private long phoneNum;
	private long creationTime;
	private String email;
	private long lastModifiedTime;
	@OneToOne
	@JoinColumn(name = "address", nullable = false)
	private AddressEntity addressEntity;
	@Type(type = "json")
	@Column(columnDefinition = "json")
	InventoryCollectionNode inventoryCollectionNode ;
	@OneToOne
	@JoinColumn(name = "login", nullable = false)
	private LoginEntity loginEntity;
	
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
	public AddressEntity getAddressEntity() {
		return addressEntity;
	}
	public void setAddressEntity(AddressEntity addressEntity) {
		this.addressEntity = addressEntity;
	}
	public InventoryCollectionNode getInventoryCollectionNode() {
		return inventoryCollectionNode;
	}
	public void setInventoryCollectionNode(InventoryCollectionNode inventoryCollectionNode) {
		this.inventoryCollectionNode = inventoryCollectionNode;
	}
	public LoginEntity getLoginEntity() {
		return loginEntity;
	}
	public void setLoginEntity(LoginEntity loginEntity) {
		this.loginEntity = loginEntity;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
