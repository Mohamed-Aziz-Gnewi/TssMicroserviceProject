package com.TssCommerce.TssProduct.Repository;

import com.TssCommerce.TssProduct.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product getProductByProductName(String productName);
    public Product getProductById(Long id);

}
