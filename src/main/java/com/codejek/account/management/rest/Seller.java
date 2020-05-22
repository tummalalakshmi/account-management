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

import com.codejek.account.management.model.SellerModel;
import com.codejek.account.management.processor.SellerProcessor;

@Controller
@RequestMapping(path="/seller")
public class Seller {

	private static final Logger log = LoggerFactory.getLogger(Seller.class);
	@Autowired
	SellerProcessor sellerProcessor;
	@PostMapping(path="/")
	public @ResponseBody String addSeller (@RequestBody SellerModel sellerModel) {

		log.info("Adding Product Inventory"+sellerModel.toString());
		if(sellerProcessor.addSeller(sellerModel)>0){
			return "Saved";
		}
		return "Error";
	}
	
	@PutMapping(path="/")
	public @ResponseBody String modifySeller (@RequestBody SellerModel sellerModel) {

		if(sellerProcessor.modifySeller(sellerModel)>0){
			return "Modified";
		}
		return "Error";
	}
	
	@GetMapping(path="/")
	public @ResponseBody List<SellerModel> findAllSellers(){
		
		return sellerProcessor.findAllSellers();
	}

	@DeleteMapping(path="/{id}")
	public @ResponseBody void deleteSeller(@PathVariable("id") Long id) {
		
		sellerProcessor.removeSeller(id);
	}
}
