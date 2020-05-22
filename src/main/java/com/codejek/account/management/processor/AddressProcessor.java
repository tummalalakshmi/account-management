package com.codejek.account.management.processor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codejek.account.management.entity.AddressEntity;
import com.codejek.account.management.model.AddressModel;
import com.codejek.account.management.service.AddressService;
import com.codejek.account.management.utils.Mapper;

@Component
public class AddressProcessor {

	@Autowired
	AddressService addressService;
	
	public AddressEntity addAddress(AddressModel addressModel) {
		
		AddressEntity addressEntity = Mapper.mapAddressModeltoEntity(addressModel);
		
		addressEntity = addressService.create(addressEntity);
		 return addressEntity;
	}
	
	public AddressEntity modifyAddress(AddressModel addressModel) {
		
		AddressEntity addressEntity = Mapper.mapAddressModeltoEntity(addressModel);
		
		addressEntity = addressService.update(addressEntity);
		 return addressEntity;
	}
	
	public AddressModel getAddressModel(long id) {
		
		AddressEntity addressEntity = addressService.get(id);
		
		return Mapper.mapAddressEntitytoModel(addressEntity);
	}
	
	public List<AddressModel> findAllAddresss(){
		
		List <AddressEntity> be = addressService.getAll();
		
		List<AddressModel> bm = new ArrayList<AddressModel>();
		for(AddressEntity b : be) {
			bm.add(Mapper.mapAddressEntitytoModel(b));
		}
		return bm;
	}
	
	public void removeAddress(long id) {
		
		addressService.delete(Mapper.mapAddressModeltoEntity(getAddressModel(id)));
	}
}
