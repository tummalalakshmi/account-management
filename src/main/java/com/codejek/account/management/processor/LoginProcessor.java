package com.codejek.account.management.processor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codejek.account.management.entity.AddressEntity;
import com.codejek.account.management.entity.LoginEntity;
import com.codejek.account.management.model.LoginModel;
import com.codejek.account.management.service.LoginService;
import com.codejek.account.management.utils.Mapper;

@Component
public class LoginProcessor {

	@Autowired
	LoginService loginService;
	
	public LoginEntity addLogin(LoginModel loginModel) {
		
		LoginEntity loginEntity = Mapper.mapLoginModeltoEntity(loginModel);
		Date date = new Date();
		loginEntity.setCreationTime(date.getTime());
		loginEntity.setLastModifiedTime(date.getTime());
		
		loginEntity = loginService.create(loginEntity);
		 return loginEntity;
	}
	
	public LoginEntity modifyLogin(LoginModel loginModel) {
		
		LoginEntity loginEntity = Mapper.mapLoginModeltoEntity(loginModel);
		Date date = new Date();
		loginEntity.setLastModifiedTime(date.getTime());
		
		loginEntity = loginService.update(loginEntity);
		 return loginEntity;
	}
	
	public LoginModel getLoginModel(long id) {
		
		LoginEntity loginEntity = loginService.get(id);
		
		return Mapper.mapLoginEntitytoModel(loginEntity);
	}
	
	public List<LoginModel> findAllLogins(){
		
		List <LoginEntity> be = loginService.getAll();
		
		List<LoginModel> bm = new ArrayList<LoginModel>();
		for(LoginEntity b : be) {
			bm.add(Mapper.mapLoginEntitytoModel(b));
		}
		return bm;
	}
	
	public void removeLogin(long id) {
		
		loginService.delete(Mapper.mapLoginModeltoEntity(getLoginModel(id)));
	}
}
