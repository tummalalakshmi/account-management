package com.codejek.account.management.service;

import java.util.List;

import com.codejek.account.management.entity.LoginEntity;

public interface LoginService {

	public LoginEntity create(LoginEntity loginEntity);
	public LoginEntity update(LoginEntity loginEntity);
	public LoginEntity get(long id);
	public List<LoginEntity> getAll();
	public void delete(LoginEntity loginEntity);
}
