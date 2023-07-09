package com.foly.assignment.service.impl;

import com.foly.assignment.dao.AccountDao;
import com.foly.assignment.entity.Account;
import com.foly.assignment.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao dao;

    public List<Account> findAllById(Iterable<String> strings) {
        return dao.findAllById(strings);
    }

    public List<Account> findAll() {
        return dao.findAll();
    }

    public <S extends Account> S save(S entity) {
        return dao.save(entity);
    }

    public Optional<Account> findByUser(String s) {
        return dao.findById(s);
    }

    public void deleteById(String s) {
        dao.deleteById(s);
    }

    public void delete(Account entity) {
        dao.delete(entity);
    }

    @Override
    @Deprecated
    public Account getOne(String s) {
        return dao.getOne(s);
    }

    public Page<Account> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }
}
