package com.vixsys.dscommerce.repositories;

import com.vixsys.dscommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>
{

}
