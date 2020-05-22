package com.codejek.account.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codejek.account.management.entity.LoginEntity;
import com.codejek.account.management.repository.LoginRepository;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginRepository loginRepository;
	
	@Override
	public LoginEntity create(LoginEntity loginEntity) {
		
		return loginRepository.save(loginEntity);
	}

	@Override
	public LoginEntity update(LoginEntity loginEntity) {
		
		return loginRepository.save(loginEntity);
	}

	@Override
	public LoginEntity get(long id) {
		
		return loginRepository.getOne(id);
	}

	@Override
	public List<LoginEntity> getAll() {
		
		return loginRepository.findAll();
	}

	@Override
	public void delete(LoginEntity loginEntity) {
		
		loginRepository.delete(loginEntity);
	}
}
