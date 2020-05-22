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

import com.codejek.account.management.model.UserModel;
import com.codejek.account.management.processor.UserProcessor;

@Controller
@RequestMapping(path="/user")
public class User {

	private static final Logger log = LoggerFactory.getLogger(User.class);
	@Autowired
	UserProcessor userProcessor;
	@PostMapping(path="/")
	public @ResponseBody String addUser (@RequestBody UserModel userModel) {

		log.info("Adding Product Inventory");
		if(userProcessor.addUser(userModel)>0){
			return "Saved";
		}
		return "Error";
	}
	
	@PutMapping(path="/")
	public @ResponseBody String modifyUser (@RequestBody UserModel userModel) {

		if(userProcessor.modifyUser(userModel)>0){
			return "Modified";
		}
		return "Error";
	}
	
	@GetMapping(path="/")
	public @ResponseBody List<UserModel> findAllUsers(){
		
		return userProcessor.findAllUsers();
	}

	@DeleteMapping(path="/{id}")
	public @ResponseBody void deleteUser(@PathVariable("id") Long id) {
		
		userProcessor.removeUser(id);
	}
}
