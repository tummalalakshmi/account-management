package com.codejek.account.management.service;

import java.util.List;

import com.codejek.account.management.entity.AddressEntity;

public interface AddressService {

	public AddressEntity create(AddressEntity addressEntity);
	public AddressEntity update(AddressEntity addressEntity);
	public AddressEntity get(long id);
	public List<AddressEntity> getAll();
	public void delete(AddressEntity addressEntity);
}
