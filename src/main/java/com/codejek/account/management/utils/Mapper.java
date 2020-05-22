package com.codejek.account.management.utils;

import java.util.ArrayList;
import java.util.List;

import com.codejek.account.management.entity.AddressEntity;
import com.codejek.account.management.entity.CompanyAgentEntity;
import com.codejek.account.management.entity.LoginEntity;
import com.codejek.account.management.entity.SellerEntity;
import com.codejek.account.management.entity.UserEntity;
import com.codejek.account.management.model.AddressModel;
import com.codejek.account.management.model.CompanyAgentModel;
import com.codejek.account.management.model.LoginModel;
import com.codejek.account.management.model.SellerModel;
import com.codejek.account.management.model.UserModel;

public class Mapper {

	public static AddressEntity mapAddressModeltoEntity(AddressModel addressModel) {
		
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setId(addressModel.getId());
		addressEntity.setAddressDetails(addressModel.getAddressDetails());
		addressEntity.setCountry(addressModel.getCountry());
		addressEntity.setDistrict(addressModel.getDistrict());
		addressEntity.setLocation(addressModel.getLocation());
		addressEntity.setPinCode(addressModel.getPinCode());
		addressEntity.setState(addressModel.getState());
		return addressEntity;
	}

	public static AddressModel mapAddressEntitytoModel(AddressEntity addressEntity) {
		
		AddressModel addressModel = new AddressModel();
		addressModel.setId(addressEntity.getId());
		addressModel.setAddressDetails(addressEntity.getAddressDetails());
		addressModel.setCountry(addressEntity.getCountry());
		addressModel.setDistrict(addressEntity.getDistrict());
		addressModel.setLocation(addressEntity.getLocation());
		addressModel.setPinCode(addressEntity.getPinCode());
		addressModel.setState(addressEntity.getState());
		return addressModel;
	}

	public static CompanyAgentModel mapCompanyAgentEntitytoModel(CompanyAgentEntity companyAgentEntity) {
		
		CompanyAgentModel companyAgentModel = new CompanyAgentModel();
		companyAgentModel.setAddressModel(mapAddressEntitytoModel(companyAgentEntity.getAddressEntity()));
		companyAgentModel.setId(companyAgentEntity.getId());
		companyAgentModel.setLoginModel(mapLoginEntitytoModel(companyAgentEntity.getLoginEntity()));
		String names[] = companyAgentEntity.getName().split("_");
		if(names.length == 2) {
			companyAgentModel.setFirstName(names[0]);
			companyAgentModel.setLastName(names[1]);
		}
		companyAgentModel.setPhoneNum(companyAgentEntity.getPhoneNum());
		return companyAgentModel;
	}

	public static CompanyAgentEntity mapCompanyAgentModeltoEntity(CompanyAgentModel companyAgentModel) {

		CompanyAgentEntity companyAgentEntity = new CompanyAgentEntity();
		companyAgentEntity.setAddressEntity(mapAddressModeltoEntity(companyAgentModel.getAddressModel()));
		companyAgentEntity.setId(companyAgentModel.getId());
		companyAgentEntity.setLoginEntity(mapLoginModeltoEntity(companyAgentModel.getLoginModel()));
		companyAgentEntity.setName(companyAgentModel.getFirstName()+"_"+companyAgentModel.getLastName());
		companyAgentEntity.setPhoneNum(companyAgentModel.getPhoneNum());
		return companyAgentEntity;
	}

	public static LoginModel mapLoginEntitytoModel(LoginEntity loginEntity) {

		LoginModel loginModel = new LoginModel();
		loginModel.setCreationTime(loginEntity.getCreationTime());
		loginModel.setId(loginEntity.getId());
		loginModel.setLastModifiedTime(loginEntity.getLastModifiedTime());
		loginModel.setOldpwd1(loginEntity.getOldpwd1());
		loginModel.setOldpwd2(loginEntity.getOldpwd2());
		loginModel.setOldpwd3(loginEntity.getOldpwd3());
		loginModel.setPassword(loginEntity.getPassword());
		loginModel.setPwdHint(loginEntity.getPwdHint());
		loginModel.setUsername(loginEntity.getUsername());
		return loginModel;
	}

	public static LoginEntity mapLoginModeltoEntity(LoginModel loginModel) {

		LoginEntity loginEntity = new LoginEntity();
		loginEntity.setId(loginModel.getId());
		loginEntity.setOldpwd1(loginModel.getOldpwd1());
		loginEntity.setOldpwd2(loginModel.getOldpwd2());
		loginEntity.setOldpwd3(loginModel.getOldpwd3());
		loginEntity.setPassword(loginModel.getPassword());
		loginEntity.setPwdHint(loginModel.getPwdHint());
		loginEntity.setUsername(loginModel.getUsername());
		return loginEntity;
	}

	public static SellerModel mapSellerEntitytoModel(SellerEntity sellerEntity) {

		SellerModel sellerModel = new SellerModel();
		sellerModel.setAddressModel(mapAddressEntitytoModel(sellerEntity.getAddressEntity()));
		sellerModel.setCreationTime(sellerEntity.getCreationTime());
		sellerModel.setId(sellerEntity.getId());
		sellerModel.setInventoryCollectionNode(sellerEntity.getInventoryCollectionNode());
		sellerModel.setLastModifiedTime(sellerEntity.getLastModifiedTime());
		sellerModel.setLoginModel(mapLoginEntitytoModel(sellerEntity.getLoginEntity()));
		String names[] = sellerEntity.getName().split("_");
		if(names.length == 2) {
			sellerModel.setFirstName(names[0]);
			sellerModel.setLastName(names[1]);
		}
		sellerModel.setPhoneNum(sellerEntity.getPhoneNum());
		return sellerModel;
	}

	public static SellerEntity mapSellerModeltoEntity(SellerModel sellerModel) {

		SellerEntity sellerEntity = new SellerEntity();
//		sellerEntity.setAddressEntity(mapAddressModeltoEntity(sellerModel.getAddressModel()));
		sellerEntity.setId(sellerModel.getId());
		sellerEntity.setInventoryCollectionNode(sellerModel.getInventoryCollectionNode());
		sellerEntity.setLoginEntity(mapLoginModeltoEntity(sellerModel.getLoginModel()));
		sellerEntity.setName(sellerModel.getFirstName()+ "_"+sellerModel.getLastName());
		sellerEntity.setPhoneNum(sellerModel.getPhoneNum());
		return sellerEntity;
	}

	public static UserModel mapUserEntitytoModel(UserEntity userEntity) {
			
		UserModel userModel = new UserModel();
		List<AddressModel> addressModels = new ArrayList<AddressModel>();
		for(AddressEntity a : userEntity.getAddressEntity()) {
			addressModels.add(mapAddressEntitytoModel(a));
		}
		userModel.setAddressModels(addressModels);
		userModel.setCreationTime(userEntity.getCreationTime());
		userModel.setId(userEntity.getId());
		userModel.setLastModifiedTime(userEntity.getLastModifiedTime());
		userModel.setLoginModel(mapLoginEntitytoModel(userEntity.getLoginEntity()));
		String names[] = userEntity.getName().split("_");
		if(names.length == 2) {
			userModel.setFirstName(names[0]);
			userModel.setLastName(names[1]);
		}
		userModel.setPhoneNum(userEntity.getPhoneNum());
		return userModel;
	}

	public static UserEntity mapUserModeltoEntity(UserModel userModel) {

		UserEntity userEntity = new UserEntity();
		List<AddressEntity> addressEntity = new ArrayList<AddressEntity>();
		for(AddressModel a : userModel.getAddressModels()) {
			addressEntity.add(mapAddressModeltoEntity(a));
		}
		userEntity.setAddressEntity(addressEntity);
		userEntity.setId(userModel.getId());
		userEntity.setLoginEntity(mapLoginModeltoEntity(userModel.getLoginModel()));
		userEntity.setName(userModel.getFirstName()+"_"+userModel.getLastName());
		userEntity.setPhoneNum(userModel.getPhoneNum());
		return userEntity;
	}

	
	
}
