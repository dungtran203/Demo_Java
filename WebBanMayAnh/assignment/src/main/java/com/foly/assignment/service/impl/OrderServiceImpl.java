package com.foly.assignment.service.impl;

import com.foly.assignment.dao.OrderDao;
import com.foly.assignment.dao.OrderDetailDao;
import com.foly.assignment.entity.Order;
import com.foly.assignment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao dao;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public List<Order> findAll() {
        return dao.findAll();
    }

    @Override
    public <S extends Order> S save(S entity) {
        return dao.save(entity);
    }

    @Override
    public Optional<Order> findById(Integer integer) {
        return dao.findById(integer);
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }

    @Override
    public void deleteById(Integer integer) {
        dao.deleteById(integer);
    }

}
