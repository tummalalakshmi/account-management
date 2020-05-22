package com.codejek.account.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codejek.account.management.entity.CompanyAgentEntity;
import com.codejek.account.management.repository.CompanyAgentRepository;

@Service
@Transactional
public class CompanyAgentServiceImpl implements CompanyAgentService{

	@Autowired
	CompanyAgentRepository companyAgentRepository;
	
	@Override	
	public CompanyAgentEntity create(CompanyAgentEntity companyAgentEntity) {
		
		return companyAgentRepository.save(companyAgentEntity);
	}

	@Override
	public CompanyAgentEntity update(CompanyAgentEntity companyAgentEntity) {
		
		return companyAgentRepository.save(companyAgentEntity);
	}

	@Override
	public CompanyAgentEntity get(long id) {
		
		return companyAgentRepository.getOne(id);
	}

	@Override
	public List<CompanyAgentEntity> getAll() {
		
		return companyAgentRepository.findAll();
	}

	@Override
	public void delete(CompanyAgentEntity companyAgentEntity) {
		
		companyAgentRepository.delete(companyAgentEntity);
	}
}
