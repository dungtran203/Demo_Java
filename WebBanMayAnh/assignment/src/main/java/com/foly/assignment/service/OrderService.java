package com.foly.assignment.service;

import com.foly.assignment.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> findAll();

    <S extends Order> S save(S entity);

    Optional<Order> findById(Integer integer);

    Page<Order> findAll(Pageable pageable);

    void deleteById(Integer integer);

}
