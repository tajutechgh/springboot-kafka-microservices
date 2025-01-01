package com.tajutechgh.stockservice.repository;

import com.tajutechgh.basedomains.dto.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}