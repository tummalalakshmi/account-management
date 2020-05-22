package com.codejek.account.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="company_agent")
public class CompanyAgentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "company_agent_id", updatable = false, nullable = false)
	@JsonIgnore
	private long id;
	private String name;
	private long creationTime;
	private long lastModifiedTime;
	@OneToOne
	@JoinColumn(name = "address", nullable = false)
	private AddressEntity addressEntity;
	private long phoneNum;
	@OneToOne
	@JoinColumn(name = "login", nullable = false)
	private LoginEntity loginEntity;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AddressEntity getAddressEntity() {
		return addressEntity;
	}
	public void setAddressEntity(AddressEntity addressEntity) {
		this.addressEntity = addressEntity;
	}
	public long getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}
	public LoginEntity getLoginEntity() {
		return loginEntity;
	}
	public void setLoginEntity(LoginEntity loginEntity) {
		this.loginEntity = loginEntity;
	}
}
