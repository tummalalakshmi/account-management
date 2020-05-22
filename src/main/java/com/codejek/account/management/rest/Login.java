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

import com.codejek.account.management.model.LoginModel;
import com.codejek.account.management.processor.LoginProcessor;

@Controller
@RequestMapping(path="/login")
public class Login {

	private static final Logger log = LoggerFactory.getLogger(Login.class);
	@Autowired
	LoginProcessor loginProcessor;
	@PostMapping(path="/")
	public @ResponseBody String addLogin (@RequestBody LoginModel loginModel) {

//		log.info("Adding Product Inventory");
//		if(loginProcessor.addLogin(loginModel)>0){
//			return "Saved";
//		}
		return "Error";
	}
	
	@PutMapping(path="/")
	public @ResponseBody String modifyLogin (@RequestBody LoginModel loginModel) {

//		if(loginProcessor.modifyLogin(loginModel)>0){
//			return "Modified";
//		}
		return "Error";
	}
	
	@GetMapping(path="/")
	public @ResponseBody List<LoginModel> findAllLogins(){
		
		return loginProcessor.findAllLogins();
	}

	@DeleteMapping(path="/{id}")
	public @ResponseBody void deleteLogin(@PathVariable("id") Long id) {
		
		loginProcessor.removeLogin(id);
	}
}
