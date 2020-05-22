package com.codejek.account.management.processor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.ws.soap.Addressing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codejek.account.management.entity.AddressEntity;
import com.codejek.account.management.entity.CompanyAgentEntity;
import com.codejek.account.management.entity.LoginEntity;
import com.codejek.account.management.model.CompanyAgentModel;
import com.codejek.account.management.service.AddressService;
import com.codejek.account.management.service.CompanyAgentService;
import com.codejek.account.management.utils.Mapper;

@Component
public class CompanyAgentProcessor {

	@Autowired
	CompanyAgentService companyAgentService;
	
	@Autowired
	AddressProcessor addressProcessor;
	
	@Autowired
	LoginProcessor loginProcessor;
	
	public long addCompanyAgent(CompanyAgentModel companyAgentModel) {
		
		AddressEntity addressEntity = addressProcessor.addAddress(companyAgentModel.getAddressModel());
		LoginEntity loginEntity = loginProcessor.addLogin(companyAgentModel.getLoginModel());
		CompanyAgentEntity companyAgentEntity = Mapper.mapCompanyAgentModeltoEntity(companyAgentModel);
		companyAgentEntity.setAddressEntity(addressEntity);
		companyAgentEntity.setLoginEntity(loginEntity);;
		Date date = new Date();
		companyAgentEntity.setCreationTime(date.getTime());
		companyAgentEntity.setLastModifiedTime(date.getTime());
		
		companyAgentEntity = companyAgentService.create(companyAgentEntity);
		 return companyAgentEntity.getId();
	}
	
	public long modifyCompanyAgent(CompanyAgentModel companyAgentModel) {
		
		CompanyAgentEntity companyAgentEntity = Mapper.mapCompanyAgentModeltoEntity(companyAgentModel);
		Date date = new Date();
		companyAgentEntity.setLastModifiedTime(date.getTime());
		if(companyAgentModel.getAddressModel() != null && companyAgentModel.getAddressModel().getId() > 0) {
			companyAgentEntity.setAddressEntity(addressProcessor.addAddress(companyAgentModel.getAddressModel()));
		}
//		if(companyAgentModel.getLoginModel() != null && companyAgentModel.getLoginModel().getId() > 0) {
//		LoginEntity loginEntity = loginProcessor.addLogin(companyAgentModel.getLoginModel());
		companyAgentEntity = companyAgentService.update(companyAgentEntity);
		 return companyAgentEntity.getId();
	}
	
	public CompanyAgentModel getCompanyAgentModel(long id) {
		
		CompanyAgentEntity companyAgentEntity = companyAgentService.get(id);
		
		return Mapper.mapCompanyAgentEntitytoModel(companyAgentEntity);
	}
	
	public List<CompanyAgentModel> findAllCompanyAgents(){
		
		List <CompanyAgentEntity> be = companyAgentService.getAll();
		
		List<CompanyAgentModel> bm = new ArrayList<CompanyAgentModel>();
		for(CompanyAgentEntity b : be) {
			bm.add(Mapper.mapCompanyAgentEntitytoModel(b));
		}
		return bm;
	}
	
	public void removeCompanyAgent(long id) {
		
		companyAgentService.delete(Mapper.mapCompanyAgentModeltoEntity(getCompanyAgentModel(id)));
	}
}
