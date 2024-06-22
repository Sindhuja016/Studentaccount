package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Integer>{

}
