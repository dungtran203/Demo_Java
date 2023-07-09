package com.foly.assignment.service.impl;

import com.foly.assignment.dao.ProductDao;
import com.foly.assignment.entity.Product;
import com.foly.assignment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao dao;

    @Override
    public <P extends Product> P save(P entity) {
        return dao.save(entity);
    }

    @Override
    public void deleteById(Integer integer) {
        dao.deleteById(integer);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }

    public Page<Product> findAllPage(Pageable pageable) {
        return dao.findAll(pageable);
    }

    public Optional<Product> findById(Integer integer) {
        return dao.findById(integer);
    }

}
