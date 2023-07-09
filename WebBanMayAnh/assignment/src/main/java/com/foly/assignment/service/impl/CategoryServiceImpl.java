package com.foly.assignment.service.impl;

import com.foly.assignment.dao.CategoryDao;
import com.foly.assignment.entity.Category;
import com.foly.assignment.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao dao;

    public List<Category> findAll() {
        return dao.findAll();
    }

    @Override
    public Optional<Category> findById(String s) {
        return dao.findById(s);
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }

    public <S extends Category> S save(S entity) {
        return dao.save(entity);
    }

    @Override
    public void deleteById(String s) {
        dao.deleteById(s);
    }
}
