package com.foly.assignment.dao;

import com.foly.assignment.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
//    List<Product> findByPriceBetween(double minPrice, double maxPrice);
//    Page<Product> findAllByNameLike(String keywords, Pageable pageable);
}
