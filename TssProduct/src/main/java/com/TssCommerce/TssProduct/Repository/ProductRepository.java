package com.TssCommerce.TssProduct.Repository;

import com.TssCommerce.TssProduct.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product getProductByProductName(String productName);
    public Product getProductById(Long id);
    @Query(
            value = "SELECT * FROM product p WHERE p.id in (1,2)",
            nativeQuery = true)
    List<Product> findSpecificProducts();

}
