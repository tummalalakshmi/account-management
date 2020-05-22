package com.codejek.account.management.service;

import java.util.List;

import com.codejek.account.management.entity.CompanyAgentEntity;

public interface CompanyAgentService {

	public CompanyAgentEntity create(CompanyAgentEntity companyAgentEntity);
	public CompanyAgentEntity update(CompanyAgentEntity companyAgentEntity);
	public CompanyAgentEntity get(long id);
	public List<CompanyAgentEntity> getAll();
	public void delete(CompanyAgentEntity companyAgentEntity);
}
