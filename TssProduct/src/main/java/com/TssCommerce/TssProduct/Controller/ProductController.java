package com.TssCommerce.TssProduct.Controller;

import com.TssCommerce.TssProduct.Dao.ProductDao;
import com.TssCommerce.TssProduct.Exception.ProductNotFoundException;
import com.TssCommerce.TssProduct.Model.Product;
import com.TssCommerce.TssProduct.Service.ProductServiceImp;
import com.TssCommerce.TssProduct.Wrappers.IdListTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Base64;
import java.util.List;
import java.util.Set;
import java.util.stream.*;

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

    @PostMapping("/getSpecificProducts")
    public List<Product> getSpecificProducts(@RequestBody IdListTemplate idListTemplate)
    {
        Set<Long> set = idListTemplate.getIdList().stream().collect(Collectors.toSet());

        return productService.getSpecificProducts(set);
    }
    @PostMapping("/getSpecificProductsV2")
    public List<Product> getSpecificProductsV2(@RequestBody IdListTemplate idListTemplate)
    {
        return productService.getSpecificProductsV2(idListTemplate);
    }
    @PostMapping("/getSpecificProductDao")
    public List<ProductDao> getSpecificProductDao(@RequestBody IdListTemplate idListTemplate)
    {
        Set<Long> set = idListTemplate.getIdList().stream().collect(Collectors.toSet());

        return productService.getSpecificProductsDao(set);
    }
    @PostMapping("/getSpecificProductDao2")
    public List<ProductDao> getSpecificProductDao2(@RequestBody IdListTemplate idListTemplate)
    {
        return productService.getSpecificProductsDaoV2(idListTemplate);
    }
    @PutMapping("/decreaseQuantity/{productId}/{quantity}")
    public int decreaseQuantity(@PathVariable("productId") Long productId,@PathVariable("quantity")int quantity)
    {
        return productService.decreaseQuantity(productId,quantity);
    }
    @PostMapping("/image")
    public void uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        //byte [] byteArr=file.getBytes();
        //String encodedString = Base64.getEncoder().encodeToString(byteArr);
        //byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        File path = new File("C:/Users/gnewa/OneDrive/Bureau/nudeTest.jpg");
        path.createNewFile();
        FileOutputStream output = new FileOutputStream(path);
        output.write(file.getBytes());
        output.close();
        Process process = Runtime.getRuntime().exec("python C:/Users/gnewa/OneDrive/Bureau/javaPython.py");
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
        System.out.println(in.readLine());

    }
}
