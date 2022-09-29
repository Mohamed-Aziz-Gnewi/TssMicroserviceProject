package com.TssCommerce.TssProduct.Service;

import com.TssCommerce.TssProduct.Dao.ProductDao;
import com.TssCommerce.TssProduct.Model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAll();
    public ProductDao getProductDao(Long id);
    public Product getProduct(Long id);
    public Product addProduct(Product product);
    public Product updateProduct(Product product);
    public Product deleteProduct(Long id);
}
