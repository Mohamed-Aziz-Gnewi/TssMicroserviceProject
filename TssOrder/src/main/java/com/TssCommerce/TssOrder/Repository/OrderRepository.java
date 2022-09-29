package com.TssCommerce.TssOrder.Repository;

import com.TssCommerce.TssOrder.Model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<ProductOrder,Long> {
}
