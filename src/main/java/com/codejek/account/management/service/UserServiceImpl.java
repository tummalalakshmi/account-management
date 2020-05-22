package com.codejek.account.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codejek.account.management.entity.UserEntity;
import com.codejek.account.management.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserEntity create(UserEntity userEntity) {
		
		return userRepository.save(userEntity);
	}

	@Override
	public UserEntity update(UserEntity userEntity) {
		
		return userRepository.save(userEntity);
	}

	@Override
	public UserEntity get(long id) {
		
		return userRepository.getOne(id);
	}

	@Override
	public List<UserEntity> getAll() {
		
		return userRepository.findAll();
	}

	@Override
	public void delete(UserEntity userEntity) {
		
		userRepository.delete(userEntity);
	}
}
