package com.codejek.account.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codejek.account.management.entity.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long>{

}
