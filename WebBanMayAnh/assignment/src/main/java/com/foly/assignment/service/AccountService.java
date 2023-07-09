package com.foly.assignment.service;

import com.foly.assignment.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    List<Account> findAllById(Iterable<String> strings);

    <S extends Account> S save(S entity);

    Optional<Account> findByUser(String s);

    void deleteById(String s);

    void delete(Account entity);

    Page<Account> findAll(Pageable pageable);

    Account getOne(String username);

    List<Account> findAll();
}
