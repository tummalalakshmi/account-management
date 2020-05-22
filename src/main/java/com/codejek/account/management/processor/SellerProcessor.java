package com.codejek.account.management.processor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codejek.account.management.entity.AddressEntity;
import com.codejek.account.management.entity.LoginEntity;
import com.codejek.account.management.entity.SellerEntity;
import com.codejek.account.management.model.SellerModel;
import com.codejek.account.management.service.SellerService;
import com.codejek.account.management.utils.Mapper;

@Component
public class SellerProcessor {

	@Autowired
	SellerService sellerService;
	
	@Autowired
	AddressProcessor addressProcessor;
	
	@Autowired
	LoginProcessor loginProcessor;
	
	public long addSeller(SellerModel sellerModel) {
		
		AddressEntity addressEntity = addressProcessor.addAddress(sellerModel.getAddressModel());
		LoginEntity loginEntity = loginProcessor.addLogin(sellerModel.getLoginModel());
		SellerEntity sellerEntity = Mapper.mapSellerModeltoEntity(sellerModel);
		sellerEntity.setAddressEntity(addressEntity);
		sellerEntity.setLoginEntity(loginEntity);
		Date date = new Date();
		sellerEntity.setCreationTime(date.getTime());
		sellerEntity.setLastModifiedTime(date.getTime());
		
		sellerEntity = sellerService.create(sellerEntity);
		 return sellerEntity.getId();
	}
	
	public long modifySeller(SellerModel sellerModel) {
		
		SellerEntity sellerEntity = Mapper.mapSellerModeltoEntity(sellerModel);
		Date date = new Date();
		sellerEntity.setLastModifiedTime(date.getTime());
		if(sellerModel.getAddressModel() != null && sellerModel.getAddressModel().getId() > 0) {
			sellerEntity.setAddressEntity(addressProcessor.addAddress(sellerModel.getAddressModel()));
		}
		sellerEntity = sellerService.update(sellerEntity);
		 return sellerEntity.getId();
	}
	
	public SellerModel getSellerModel(long id) {
		
		SellerEntity sellerEntity = sellerService.get(id);
		
		return Mapper.mapSellerEntitytoModel(sellerEntity);
	}
	
	public List<SellerModel> findAllSellers(){
		
		List <SellerEntity> be = sellerService.getAll();
		
		List<SellerModel> bm = new ArrayList<SellerModel>();
		for(SellerEntity b : be) {
			bm.add(Mapper.mapSellerEntitytoModel(b));
		}
		return bm;
	}
	
	public void removeSeller(long id) {
		
		sellerService.delete(Mapper.mapSellerModeltoEntity(getSellerModel(id)));
	}
}
