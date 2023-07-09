package com.foly.assignment.service;

import com.foly.assignment.entity.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderDetailService {

    Page<OrderDetail> findAll(Pageable pageable);

    List<OrderDetail> findAll();

    <S extends OrderDetail> S save(S entity);

}
