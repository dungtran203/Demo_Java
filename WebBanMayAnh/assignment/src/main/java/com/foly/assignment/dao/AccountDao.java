package com.foly.assignment.dao;

import com.foly.assignment.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends JpaRepository<Account, String>{
	
	
}
