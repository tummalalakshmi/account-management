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

import com.codejek.account.management.model.CompanyAgentModel;
import com.codejek.account.management.processor.CompanyAgentProcessor;

@Controller
@RequestMapping(path="/companyAgent")
public class CompanyAgent {

	private static final Logger log = LoggerFactory.getLogger(CompanyAgent.class);
	@Autowired
	CompanyAgentProcessor companyAgentProcessor;
	@PostMapping(path="/")
	public @ResponseBody String addCompanyAgent (@RequestBody CompanyAgentModel companyAgentModel) {

		log.info("Adding Company Agent");
		if(companyAgentProcessor.addCompanyAgent(companyAgentModel)>0){
			return "Saved";
		}
		return "Error";
	}
	
	@PutMapping(path="/")
	public @ResponseBody String modifyCompanyAgent (@RequestBody CompanyAgentModel companyAgentModel) {

		if(companyAgentProcessor.modifyCompanyAgent(companyAgentModel)>0){
			return "Modified";
		}
		return "Error";
	}
	
	@GetMapping(path="/")
	public @ResponseBody List<CompanyAgentModel> findAllCompanyAgents(){
		
		return companyAgentProcessor.findAllCompanyAgents();
	}

	@DeleteMapping(path="/{id}")
	public @ResponseBody void deleteCompanyAgent(@PathVariable("id") Long id) {
		
		companyAgentProcessor.removeCompanyAgent(id);
	}
}
