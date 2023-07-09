package com.foly.assignment.service;

import com.foly.assignment.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {

    <S extends Product> S save(S entity);

    abstract void deleteById(Integer integer);

    Page<Product> findAll(Pageable pageable);

    Page<Product> findAllPage(Pageable pageable);

    Optional<Product> findById(Integer integer);

}

