package com.codejek.account.management.processor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codejek.account.management.entity.AddressEntity;
import com.codejek.account.management.entity.LoginEntity;
import com.codejek.account.management.entity.UserEntity;
import com.codejek.account.management.model.AddressModel;
import com.codejek.account.management.model.UserModel;
import com.codejek.account.management.service.UserService;
import com.codejek.account.management.utils.Mapper;

@Component
public class UserProcessor {

	@Autowired
	UserService userService;
	
	@Autowired
	AddressProcessor addressProcessor;
	
	@Autowired
	LoginProcessor loginProcessor;
	
	public long addUser(UserModel userModel) {
		
		List<AddressEntity> addressEntitys = new ArrayList<AddressEntity>();
		for(AddressModel addressModel : userModel.getAddressModels()) {
			addressEntitys.add(addressProcessor.addAddress(addressModel));
		}
		LoginEntity loginEntity = loginProcessor.addLogin(userModel.getLoginModel());
		UserEntity userEntity = Mapper.mapUserModeltoEntity(userModel);
		Date date = new Date();
		userEntity.setCreationTime(date.getTime());
		userEntity.setLastModifiedTime(date.getTime());
		userEntity.setAddressEntity(addressEntitys);
		userEntity.setLoginEntity(loginEntity);
		userEntity = userService.create(userEntity);
		return userEntity.getId();
	}
	
	public long modifyUser(UserModel userModel) {
		
		UserEntity userEntity = Mapper.mapUserModeltoEntity(userModel);
		Date date = new Date();
		userEntity.setLastModifiedTime(date.getTime());
		
		userEntity = userService.update(userEntity);
		 return userEntity.getId();
	}
	
	public UserModel getUserModel(long id) {
		
		UserEntity userEntity = userService.get(id);
		
		return Mapper.mapUserEntitytoModel(userEntity);
	}
	
	public List<UserModel> findAllUsers(){
		
		List <UserEntity> be = userService.getAll();
		
		List<UserModel> bm = new ArrayList<UserModel>();
		for(UserEntity b : be) {
			bm.add(Mapper.mapUserEntitytoModel(b));
		}
		return bm;
	}
	
	public void removeUser(long id) {
		
		userService.delete(Mapper.mapUserModeltoEntity(getUserModel(id)));
	}
}
