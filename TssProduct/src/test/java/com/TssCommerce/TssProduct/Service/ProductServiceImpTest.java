package com.TssCommerce.TssProduct.Service;

import com.TssCommerce.TssProduct.Dao.ProductDao;
import com.TssCommerce.TssProduct.Exception.ProductExistantException;
import com.TssCommerce.TssProduct.Exception.ProductNotFoundException;
import com.TssCommerce.TssProduct.Model.Product;
import com.TssCommerce.TssProduct.Repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceImpTest {

    @Mock
    private ProductRepository productRepository;


    private ProductServiceImp productServiceImp ;

    @BeforeEach
    void setUp()
    {
        productServiceImp = new ProductServiceImp(productRepository);
    }

    @Test
    void getAll() {
        productServiceImp.getAll();
        verify(productRepository).findAll();
    }

    @Test
    void getProduct() {
        Product product = new Product(1L,"testproduct","",1.4,1);

        given(productRepository.findById(1L)).willReturn(Optional.of(product));
        productServiceImp.getProduct(1L);
        verify(productRepository).findById(1L);
    }

    @Test
    void addProduct() {
        Product product = new Product(1L,"testproduct","",1.4,1);

        //given(productRepository.getProductByProductName(anyString()) != null).willReturn(true);
        //then
        productServiceImp.addProduct(product);
        /*
        ArgumentCaptor<Product> productArgumentCaptor =
                ArgumentCaptor.forClass(Product.class);
        verify(productRepository).save(productArgumentCaptor.capture());
        Product capturedProduct = productArgumentCaptor.getValue();

        assertThat(capturedProduct).isEqualTo(product);
        */
         verify(productRepository).save(product);

    }

    @Test
    void updateProduct() {

        Product productToUpdate = new Product(1L,"testproduct","",1.4,1);
        Product product = new Product(1L,"testproduct","",1.4,1);

        given(productRepository.getProductById(1L)).willReturn(productToUpdate);
        //then
        productServiceImp.updateProduct(product);
        ArgumentCaptor<Product> productArgumentCaptor =
                ArgumentCaptor.forClass(Product.class);
        verify(productRepository).save(productArgumentCaptor.capture());
        Product capturedProduct = productArgumentCaptor.getValue();
        assertThat(capturedProduct).isEqualTo(product);
    }

    @Test
    void deleteProduct() {
        Product product = new Product(1L,"testproduct","",1.4,1);
        given(productRepository.findById(1L)).willReturn(Optional.of(product));
        productServiceImp.deleteProduct(1L);
        verify(productRepository).deleteById(1L);

    }
    @Test
    void addProductException()
    {
        Product product = new Product(1L,"testproduct","",1.4,1);
        given(productRepository.getProductByProductName(product.getProductName())).willReturn(product);

        assertThatThrownBy(()-> productServiceImp.addProduct(product))
                .isInstanceOf(ProductExistantException.class)
                .hasMessage("the product is already existant");

    }
    @Test
    void updateProductException()
    {
        Product product = new Product(1L,"testproduct","",1.4,1);
        given(productRepository.getProductById(product.getId())).willReturn(null);

        assertThatThrownBy(()-> productServiceImp.updateProduct(product))
                .isInstanceOf(ProductNotFoundException.class)
                .hasMessage("the product with id = "+ product.getId()+" not found");

    }
    @Test
    void getProductDao() {
        Product product = new Product(1L,"testproduct","",1.4,1);
        ProductDao productDao = new ProductDao(1L,"testproduct",1,1.4);
        given(productRepository.findById(1L)).willReturn(Optional.of(product));
        assertThat(productServiceImp.getProductDao(1L)).isEqualTo(productDao);

    }

    @Disabled
    @Test
    void getProductsDao() {
    }
    @Disabled
    @Test
    void decreaseQuantity() {
    }
    @Disabled
    @Test
    void getSpecificProducts() {
    }
    @Disabled
    @Test
    void getSpecificProductsDao() {
    }
}