package com.TssCommerce.TssOrder.Controller;

import com.TssCommerce.TssOrder.Dao.ProductDao;
import com.TssCommerce.TssOrder.Enum.Discount;
import com.TssCommerce.TssOrder.Enum.Status;
import com.TssCommerce.TssOrder.Model.ProductOrder;
import com.TssCommerce.TssOrder.Model.ShippedInfo;
import com.TssCommerce.TssOrder.Proxy.ProductProxy;
import com.TssCommerce.TssOrder.Repository.OrderRepository;
import com.TssCommerce.TssOrder.Repository.ProductDaoRepository;
import com.TssCommerce.TssOrder.Service.OrderServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.DatatypeConverter;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public OrderController(OrderServiceImp orderServiceImp, ProductProxy productProxy) {
        this.orderServiceImp = orderServiceImp;
        this.productProxy = productProxy;
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

    @PostMapping("/addOrder")
    ProductOrder addOrder()
    {
        return orderServiceImp.addOrder();
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
    @GetMapping("/testString")
    ShippedInfo testJsonToString() throws JsonProcessingException {

        ShippedInfo shippedInfo = new ShippedInfo(1L,"First shipped","Company name","my addrr",1022,2399999);

        //Creating the ObjectMapper object
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = mapper.writeValueAsString(shippedInfo);

        ShippedInfo shippedInfo1 = mapper.readValue(jsonString,ShippedInfo.class);

        return shippedInfo1;


    }

}
