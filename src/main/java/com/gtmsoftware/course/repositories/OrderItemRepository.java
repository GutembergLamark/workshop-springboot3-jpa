package com.gtmsoftware.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gtmsoftware.course.entities.OrderItem;
import com.gtmsoftware.course.entities.enums.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
	
}
