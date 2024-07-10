package com.vixsys.dscommerce.repositories;

import com.vixsys.dscommerce.entities.OrderItem;
import com.vixsys.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>
{

}
