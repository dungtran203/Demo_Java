package com.foly.assignment.dao;

import com.foly.assignment.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailDao extends JpaRepository<OrderDetail, Long> {
}
