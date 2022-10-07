package com.TssCommerce.TssOrder.Controller;

import com.TssCommerce.TssOrder.Dao.ProductDao;
import com.TssCommerce.TssOrder.Dao.ShipmentInfo;
import com.TssCommerce.TssOrder.Dao.User;
import com.TssCommerce.TssOrder.Enum.Discount;
import com.TssCommerce.TssOrder.Enum.Status;
import com.TssCommerce.TssOrder.Model.ProductOrder;
import com.TssCommerce.TssOrder.Proxy.ProductProxy;
import com.TssCommerce.TssOrder.Proxy.UserProxy;
import com.TssCommerce.TssOrder.Repository.OrderRepository;
import com.TssCommerce.TssOrder.Repository.ProductDaoRepository;
import com.TssCommerce.TssOrder.Service.OrderServiceImp;
import com.TssCommerce.TssOrder.Wrappers.ProductIdList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/tssorder")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductDaoRepository productDaoRepository;

    public final OrderServiceImp orderServiceImp;
    public final ProductProxy productProxy;
    public final UserProxy userProxy;

    public OrderController(OrderServiceImp orderServiceImp, ProductProxy productProxy, UserProxy userProxy) {
        this.orderServiceImp = orderServiceImp;
        this.productProxy = productProxy;
        this.userProxy = userProxy;
    }

    @GetMapping("/productsProxy/{id}")
    ProductDao getProducts(@PathVariable("id") Long id)
    {
        return productProxy.getProductDao(id);
    }

    @GetMapping("/getOrder/{id}")
    ProductOrder getOrder(@PathVariable("id") Long id)
    {
        return orderRepository.findById(id).get();
    }

    @PostMapping("/addOrder/{id}")
    ProductOrder addOrder(@PathVariable("id") Long id,@RequestBody HashMap<Long,Integer> productIdUnitPriceList)
    {
        return orderServiceImp.addOrder(id,productIdUnitPriceList);
    }

    @GetMapping("/test")
    ProductOrder testOrder(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        ProductOrder productOrder = new ProductOrder(date, Status.PENDING,1L,150.0, Discount.REGULAR_DISCOUNT);
        orderRepository.save(productOrder);

       ProductDao productDao1 = new ProductDao("First product",5,13.0,productOrder);
       ProductDao productDao2 = new ProductDao("Second product",8,14.0,productOrder);
       productDaoRepository.save(productDao1);
       productDaoRepository.save(productDao2);

        return productOrder;


    }
    @GetMapping("/getShipment/{id}")
    public ShipmentInfo getShipmentById(@PathVariable("id")Long id){
        return userProxy.getShipmentById(id);
    }

    @GetMapping("/getUser/{id}")
    public User getUsertById(@PathVariable("id")Long id){
        return userProxy.getUserById(id);
    }

    @PostMapping("/test2")
    public List<ProductDao> getSpecifiedProducts(@RequestBody ProductIdList productIdList)
    {
        return productProxy.getSpecificProductDao(productIdList);
    }
    @PostMapping("/test3")
    public String  test3 ()
    {
        return productProxy.testing();
    }

}
