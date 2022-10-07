package com.TssCommerce.TssOrder.Service;

import com.TssCommerce.TssOrder.Dao.ProductDao;
import com.TssCommerce.TssOrder.Enum.Discount;
import com.TssCommerce.TssOrder.Enum.Status;
import com.TssCommerce.TssOrder.Model.ProductOrder;
import com.TssCommerce.TssOrder.Proxy.ProductProxy;
import com.TssCommerce.TssOrder.Proxy.UserProxy;
import com.TssCommerce.TssOrder.Repository.OrderRepository;
import com.TssCommerce.TssOrder.Repository.ProductDaoRepository;
import com.TssCommerce.TssOrder.Wrappers.ProductIdList;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class OrderServiceImp implements OrderService{

    public final OrderRepository orderRepository;
    public final ProductDaoRepository productDaoRepository;

    public final ProductProxy productProxy;

    public final UserProxy userProxy;

    public OrderServiceImp(OrderRepository orderRepository, ProductDaoRepository productDaoRepository, ProductProxy productProxy, UserProxy userProxy) {
        this.orderRepository = orderRepository;
        this.productDaoRepository = productDaoRepository;
        this.productProxy = productProxy;
        this.userProxy = userProxy;
    }

    @Override
    public List<ProductDao> getProducts() {
        return null;
    }

    @Override
    public ProductOrder addOrder(Long userId, HashMap<Long,Integer> productIdUnitPriceList) {

        ProductIdList productIdList = new ProductIdList(new ArrayList<>(productIdUnitPriceList.keySet()));
        Double totalPrice;
        Status status;
        Discount discount;
        status = Status.PENDING;
        Date date = new Date(System.currentTimeMillis());
        List<ProductDao> productDaoList = productProxy.getSpecificProductDao(productIdList);
        totalPrice = setTotalPrice(productDaoList);
        discount = setDiscount(totalPrice);
        ProductOrder productOrder = new ProductOrder(date,status,userId,totalPrice,discount);
        orderRepository.save(productOrder);

        for (ProductDao productdao:productDaoList
             ) {
            Integer newQuantity = productIdUnitPriceList.get(productdao.getId());
            productDaoRepository.save(new ProductDao(productdao.getId(),productdao.getProductName(),newQuantity,productdao.getUnitPrice(),productOrder));
            productProxy.decreaseQuantity(productdao.getId(),newQuantity);
        }


        return productOrder;


    }

    @Override
    public ProductOrder getOrderById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public Double setTotalPrice(List<ProductDao> productDaoList) {
        Double totalePrice = 0.0;

        for (ProductDao productDao:productDaoList
             ) {
            totalePrice += productDao.getUnitPrice();
        }
        
        return totalePrice;
    }

    @Override
    public Discount setDiscount(Double totalPrice) {
        if(totalPrice<300.00)
        {
            return Discount.REGULAR_DISCOUNT;
        }
        else if (totalPrice<700.00) {
            return Discount.INTERMEDIATE_DISCOUNT;
        }
        return Discount.SPECIAL_DISCOUNT;
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
