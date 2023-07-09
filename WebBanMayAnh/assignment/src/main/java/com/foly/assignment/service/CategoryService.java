package com.foly.assignment.service;

import com.foly.assignment.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();

    Optional<Category> findById(String s);

    Page<Category> findAll(Pageable pageable);

    <S extends Category> S save(S entity);

    void deleteById(String s);
}
