package com.TssCommerce.TssProduct.Service;

import com.TssCommerce.TssProduct.Dao.ProductDao;
import com.TssCommerce.TssProduct.Exception.ProductExistantException;
import com.TssCommerce.TssProduct.Exception.ProductNotFoundException;
import com.TssCommerce.TssProduct.Model.Product;
import com.TssCommerce.TssProduct.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService {


    final private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductDao getProductDao(Long id) {
        Product product = productRepository.findById(id).get();
        ProductDao productDao = new ProductDao(product.getId(), product.getProductName(), product.getQuantity(), product.getUnitPrice());
        return productDao;
    }

    @Override
    public List<ProductDao> getProductsDao(List<Long> idList) {

        return null;
    }

    @Override
    public Product getProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("product not found id = " + id));
        return product;
    }

    @Override
    public Product addProduct(Product product) {
        Product existantProduct = productRepository.getProductByProductName(product.getProductName());
        if(existantProduct != null) throw new ProductExistantException("the product is already existant");
        productRepository.save(product);
        return product;
    }

    @Override
    public Product updateProduct(Product product) {

        Product existantProduct = productRepository.getProductById(product.getId());
        if(existantProduct == null) throw new ProductNotFoundException("the product with id = "+ product.getId()+" not found");;
        productRepository.save(product);
        return product ;
    }

    @Override
    public Product deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("the product with id = "+id+" is not found"));
        productRepository.deleteById(id);
        return product;
    }
    public List<Product> getSpecificProducts(Set<Long> productIdSet) {
        return productRepository.findSpecificProducts(productIdSet);
    }
    public List<ProductDao> getSpecificProductsDao(Set<Long> productIdSet) {

        List<Product> productList = productRepository.findSpecificProducts(productIdSet);
        List<ProductDao> productDaos = new ArrayList<>();
        for (Product product:productList
             ) {
            productDaos.add(new ProductDao(product.getId(), product.getProductName(), product.getQuantity(), product.getUnitPrice()));
        }

        return productDaos;
    }
}
