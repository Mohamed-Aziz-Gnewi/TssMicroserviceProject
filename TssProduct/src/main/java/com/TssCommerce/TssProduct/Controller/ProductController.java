package com.TssCommerce.TssProduct.Controller;

import com.TssCommerce.TssProduct.Dao.ProductDao;
import com.TssCommerce.TssProduct.Exception.ProductNotFoundException;
import com.TssCommerce.TssProduct.Model.Product;
import com.TssCommerce.TssProduct.Service.ProductServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tssproduct")
public class ProductController {
    private final ProductServiceImp productService;

    @GetMapping ("/getAll")
    public List<Product> getProducts() {

        List<Product> products = productService.getAll();
        if(products.isEmpty()) throw new ProductNotFoundException("No product is found");
        return products;

    }

    @GetMapping("/getProduct/{id}")

    public Product getProduct(@PathVariable("id")Long id)
    {

            return productService.getProduct(id);
    }
    @GetMapping("/getProductDao/{id}")

    public ProductDao getProductDao(@PathVariable("id")Long id)
    {

        return productService.getProductDao(id);
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product)
    {
        return productService.addProduct(product);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product)
    {
        return productService.updateProduct(product);
    }
    @DeleteMapping("/deleteProduct/{id}")
    public Product deletePoduct(@PathVariable("id") Long id)
    {
        return productService.deleteProduct(id);
    }

    @GetMapping("/test")
    public String testing()
    {
        return "test succ";
    }
}
