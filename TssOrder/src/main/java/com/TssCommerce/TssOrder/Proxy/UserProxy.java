package com.TssCommerce.TssOrder.Proxy;

import com.TssCommerce.TssOrder.Dao.ProductDao;
import com.TssCommerce.TssOrder.Dao.ShipmentInfo;
import com.TssCommerce.TssOrder.Dao.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="tssuser")
public interface UserProxy {
    @GetMapping("/tssuser/userDao/{id}")

    public ProductDao getProductDao(@PathVariable("id")Long id);

    @GetMapping("/tssuser/getShipment/{id}")
    public ShipmentInfo getShipmentById(@PathVariable("id") Long id);

    @GetMapping("/tssuser/userDao/{id}")
    public User getUserById(@PathVariable("id") Long id);
}
