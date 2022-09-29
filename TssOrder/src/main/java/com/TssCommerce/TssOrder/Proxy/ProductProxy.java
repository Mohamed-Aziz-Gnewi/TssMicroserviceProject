package com.TssCommerce.TssOrder.Proxy;

import com.TssCommerce.TssOrder.Dao.ProductDao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="tssproduct")
public interface ProductProxy {

    @GetMapping("/tssproduct/getProductDao/{id}")

    public ProductDao getProductDao(@PathVariable("id")Long id);
}
