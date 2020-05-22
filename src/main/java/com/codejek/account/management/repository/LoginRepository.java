package com.codejek.account.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codejek.account.management.entity.LoginEntity;

public interface LoginRepository extends JpaRepository<LoginEntity, Long>{

}
