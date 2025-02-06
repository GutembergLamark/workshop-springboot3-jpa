package com.gtmsoftware.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtmsoftware.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
