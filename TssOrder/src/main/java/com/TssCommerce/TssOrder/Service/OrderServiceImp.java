package com.TssCommerce.TssOrder.Service;

import com.TssCommerce.TssOrder.Dao.ProductDao;
import com.TssCommerce.TssOrder.Model.ProductOrder;
import com.TssCommerce.TssOrder.Repository.OrderRepository;
import com.TssCommerce.TssOrder.Repository.ProductDaoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImp implements OrderService{

    public final OrderRepository orderRepository;
    public final ProductDaoRepository productDaoRepository;

    public OrderServiceImp(OrderRepository orderRepository, ProductDaoRepository productDaoRepository) {
        this.orderRepository = orderRepository;
        this.productDaoRepository = productDaoRepository;
    }

    @Override
    public List<ProductDao> getProducts() {
        return null;
    }

    @Override
    public ProductOrder addOrder() {
        ProductOrder newOrder = new ProductOrder();


        return newOrder;
    }

    @Override
    public ProductOrder getOrderById(Long id) {
        return orderRepository.findById(id).get();
    }
}
