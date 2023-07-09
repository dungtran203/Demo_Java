package com.foly.assignment.service.impl;

import com.foly.assignment.dao.OrderDetailDao;
import com.foly.assignment.entity.OrderDetail;
import com.foly.assignment.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailDao dao;

    public Page<OrderDetail> findAll(Pageable pageable) {
        return dao.findAll(pageable);
    }

    public List<OrderDetail> findAll() {
        return dao.findAll();
    }

    public <S extends OrderDetail> S save(S entity) {
        return dao.save(entity);
    }

}
