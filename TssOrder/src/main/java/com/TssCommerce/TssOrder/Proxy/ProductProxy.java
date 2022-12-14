package com.TssCommerce.TssOrder.Proxy;

import com.TssCommerce.TssOrder.Dao.ProductDao;
import com.TssCommerce.TssOrder.Wrappers.ProductIdList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="tssproduct")
public interface ProductProxy {

    @GetMapping("/tssproduct/getProductDao/{id}")
    public ProductDao getProductDao(@PathVariable("id")Long id);
    @PostMapping("/tssproduct/getSpecificProductDao")
    public List<ProductDao> getSpecificProductDao(@RequestBody ProductIdList productIdList);
    @PostMapping("/tssproduct/testing")
    public String testing();

    @PutMapping("/tssproduct/decreaseQuantity/{productId}/{quantity}")
    public int decreaseQuantity(@PathVariable("productId") Long productId,@PathVariable("quantity")int quantity);
}
