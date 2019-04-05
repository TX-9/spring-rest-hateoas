package com.tx9.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tx9.payroll.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
