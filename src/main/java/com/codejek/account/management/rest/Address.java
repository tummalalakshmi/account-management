package com.codejek.account.management.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codejek.account.management.model.AddressModel;
import com.codejek.account.management.processor.AddressProcessor;

@Controller
@RequestMapping(path="/address")
public class Address {

	private static final Logger log = LoggerFactory.getLogger(Address.class);
	@Autowired
	AddressProcessor addressProcessor;
	@PostMapping(path="/")
	public @ResponseBody String addAddress (@RequestBody AddressModel addressModel) {

//		log.info("Adding Product Inventory");
//		if(addressProcessor.addAddress(addressModel)>0){
//			return "Saved";
//		}
		return "Error";
	}
	
	@PutMapping(path="/")
	public @ResponseBody String modifyAddress (@RequestBody AddressModel addressModel) {

//		if(addressProcessor.modifyAddress(addressModel)>0){
//			return "Modified";
//		}
		return "Error";
	}
	
	@GetMapping(path="/")
	public @ResponseBody List<AddressModel> findAllAddresss(){
		
//		return addressProcessor.findAllAddresss();
		return null;
	}

	@DeleteMapping(path="/{id}")
	public @ResponseBody void deleteAddress(@PathVariable("id") Long id) {
		
		addressProcessor.removeAddress(id);
	}
}
