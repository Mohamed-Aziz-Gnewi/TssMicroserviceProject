package com.TssCommerce.TssOrder.Repository;

import com.TssCommerce.TssOrder.Dao.ProductDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDaoRepository extends JpaRepository<ProductDao,Long> {
}
