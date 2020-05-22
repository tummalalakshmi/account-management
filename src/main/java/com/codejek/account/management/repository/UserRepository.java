package com.codejek.account.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codejek.account.management.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
