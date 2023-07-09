package com.foly.assignment.dao;

import com.foly.assignment.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LoginDao extends JpaRepository<Account, String> {

    Account findByEmail(String email);

    @Query(value = "select a from Account a where a.username=?1")
    Account getOne(String username);

    List<Account> findAll();

    @Transactional
    @Modifying
    @Query(value = "update Accounts set Password =?1 where Email=?2", nativeQuery = true)

    void capNhatMK(String password, String email);
}
