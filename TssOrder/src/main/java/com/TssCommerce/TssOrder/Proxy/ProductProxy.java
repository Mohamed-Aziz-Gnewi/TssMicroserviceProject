package com.TssCommerce.TssOrder.Proxy;

import com.TssCommerce.TssOrder.Dao.ProductDao;
import com.TssCommerce.TssOrder.Wrappers.ProductIdList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="localhost:9003/tssproduct")
public interface ProductProxy {

    @GetMapping("/tssproduct/getProductDao/{id}")
    public ProductDao getProductDao(@PathVariable("id")Long id);
    @PostMapping("/getSpecificProductDao")
    public List<ProductDao> getSpecificProductDao(@RequestBody ProductIdList productIdList);
    @PostMapping("/testing")
    public String testing();
}
