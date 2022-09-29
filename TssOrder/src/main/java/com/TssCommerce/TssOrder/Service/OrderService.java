package com.TssCommerce.TssOrder.Service;

import com.TssCommerce.TssOrder.Dao.ProductDao;
import com.TssCommerce.TssOrder.Model.ProductOrder;

import java.util.List;

public interface OrderService {
    public List<ProductDao> getProducts();
    public ProductOrder addOrder();
    public ProductOrder getOrderById(Long id);
}
