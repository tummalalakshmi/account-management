package com.codejek.account.management.service;

import java.util.List;

import com.codejek.account.management.entity.UserEntity;

public interface UserService {

	public UserEntity create(UserEntity userEntity);
	public UserEntity update(UserEntity userEntity);
	public UserEntity get(long id);
	public List<UserEntity> getAll();
	public void delete(UserEntity userEntity);
}
