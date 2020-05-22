package com.codejek.account.management.service;

import java.util.List;

import com.codejek.account.management.entity.SellerEntity;

public interface SellerService {

	public SellerEntity create(SellerEntity sellerEntity);
	public SellerEntity update(SellerEntity sellerEntity);
	public SellerEntity get(long id);
	public List<SellerEntity> getAll();
	public void delete(SellerEntity sellerEntity);
}
