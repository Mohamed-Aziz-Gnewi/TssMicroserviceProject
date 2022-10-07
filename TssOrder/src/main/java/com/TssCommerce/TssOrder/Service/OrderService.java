package com.TssCommerce.TssOrder.Service;

import com.TssCommerce.TssOrder.Dao.ProductDao;
import com.TssCommerce.TssOrder.Enum.Discount;
import com.TssCommerce.TssOrder.Model.ProductOrder;
import com.TssCommerce.TssOrder.Wrappers.ProductIdList;

import java.util.HashMap;
import java.util.List;

public interface OrderService {
    public List<ProductDao> getProducts();
    public ProductOrder addOrder(Long userId, HashMap<Long,Double> productIdUnitPriceList);
    public ProductOrder getOrderById(Long id);
    public Double setTotalPrice(List<ProductDao> productDaoList);
    public Discount setDiscount(Double totalPrice);

}
