package com.codejek.account.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codejek.account.management.entity.AddressEntity;
import com.codejek.account.management.repository.AddressRepository;

@Service
@Transactional
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressRepository addressRepository;
	
	@Override
	public AddressEntity create(AddressEntity addressEntity) {
		
		return addressRepository.save(addressEntity);
	}

	@Override
	public AddressEntity update(AddressEntity addressEntity) {
		
		return addressRepository.save(addressEntity);
	}

	@Override
	public AddressEntity get(long id) {
		
		return addressRepository.getOne(id);
	}

	@Override
	public List<AddressEntity> getAll() {
		
		return addressRepository.findAll();
	}

	@Override
	public void delete(AddressEntity addressEntity) {
		
		addressRepository.delete(addressEntity);
	}
}
