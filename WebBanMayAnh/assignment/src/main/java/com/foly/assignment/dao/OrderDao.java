package com.foly.assignment.dao;

import com.foly.assignment.entity.Order;
import com.foly.assignment.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {

    public interface OrderItemRepository extends JpaRepository<OrderDetail, Long> {
        List<OrderDetail> findByOrder(Order order);
    }

}
