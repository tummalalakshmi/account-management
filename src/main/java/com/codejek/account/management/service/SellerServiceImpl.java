package com.codejek.account.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codejek.account.management.entity.SellerEntity;
import com.codejek.account.management.repository.SellerRepository;

@Service
@Transactional
public class SellerServiceImpl implements SellerService{

	@Autowired
	SellerRepository sellerRepository;
	
	@Override
	public SellerEntity create(SellerEntity sellerEntity) {
		
		return sellerRepository.save(sellerEntity);
	}

	@Override
	public SellerEntity update(SellerEntity sellerEntity) {
		
		return sellerRepository.save(sellerEntity);
	}

	@Override
	public SellerEntity get(long id) {
		
		return sellerRepository.getOne(id);
	}

	@Override
	public List<SellerEntity> getAll() {
		
		return sellerRepository.findAll();
	}

	@Override
	public void delete(SellerEntity sellerEntity) {
		
		sellerRepository.delete(sellerEntity);
	}
}
