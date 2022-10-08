package com.TssCommerce.TssProduct.Controller;

import com.TssCommerce.TssProduct.Dao.ProductDao;
import com.TssCommerce.TssProduct.Model.Product;
import com.TssCommerce.TssProduct.Service.ProductServiceImp;
import com.TssCommerce.TssProduct.Wrappers.IdListTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @MockBean
    ProductServiceImp productServiceImp;

    @Autowired
    private MockMvc mockMvc;

    private ProductController productController;



    @Test
    void testing() throws Exception {
        mockMvc.perform(get("/tssproduct/test"))
                .andExpect(status().isOk());
    }


    @Test
    void getProducts() throws Exception {
        Product product = new Product(1L,"testproduct","",1.4,1);
        List<Product> products = Arrays.asList(product);
        //productServiceImp.addProduct(product);
        when(productServiceImp.getAll()).thenReturn(products);

        mockMvc.perform(get("/tssproduct/getAll"))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].productName", is(product.getProductName())))
                .andExpect(status().isOk());
    }



    @Test
    void getProduct() throws Exception {
        Product product = new Product(1L,"testproduct","",1.4,1);
        given(productServiceImp.getProduct(1L)).willReturn(product);

        mockMvc.perform(get("/tssproduct/getProduct/1"))
                .andExpect(jsonPath("$.productName",is(product.getProductName())))
                .andExpect(status().isOk());

    }

    @Test
    void addProduct() throws Exception {
        Product product = new Product(1L,"testproduct","",1.4,1);
        given(productServiceImp.addProduct(product)).willReturn(product);

        ObjectWriter ow = new ObjectMapper().writer();
        String content = ow.writeValueAsString(product);

        MockHttpServletRequestBuilder mockBuilder = MockMvcRequestBuilders.post("/tssproduct/addProduct")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(content);

        mockMvc.perform(mockBuilder)
                .andExpect(jsonPath("$.productName",is(product.getProductName())))
                .andExpect(status().isOk());
    }

    @Test

    void updateProduct() throws Exception {
        Product product = new Product(1L,"testproduct","",1.4,1);
        given(productServiceImp.updateProduct(product)).willReturn(product);

        ObjectWriter ow = new ObjectMapper().writer();
        String updatedContent = ow.writeValueAsString(product);

        MockHttpServletRequestBuilder mockBuilder = MockMvcRequestBuilders.put("/tssproduct/updateProduct")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(updatedContent);

        mockMvc.perform(mockBuilder)
                .andExpect(jsonPath("$.productName",is(product.getProductName())))
                .andExpect(status().isOk());
    }

    @Test
    void deletePoduct() throws Exception {
        Product product = new Product(1L,"testproduct","",1.4,1);
        given(productServiceImp.deleteProduct(1L)).willReturn(product);

        mockMvc.perform(delete("/tssproduct/deleteProduct/1"))
                .andExpect(status().isOk());

    }

    @Disabled
    @Test
    void getProductDao() throws Exception {
        ProductDao productDao = new ProductDao(1L,"testproduct",1,1.5);
        given(productServiceImp.getProductDao(1L)).willReturn(productDao);

        mockMvc.perform(get("/tssproduct/getProductDao/1"))
                .andExpect(jsonPath("$.productName",is(productDao.getProductName())))
                .andExpect(status().isOk());
    }
    @Disabled
    @Test
    void getSpecificProducts() throws Exception {
        Product product = new Product(1L,"testproduct","",1.4,1);
        //
        List<Long> list = new ArrayList<>();
        list.add(1L);
        IdListTemplate idListTemplate = new IdListTemplate(list);
        ///
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        ///
        Set<Long> idSet = new HashSet<>();
        idSet.add(1L);
        ///
       // given(productServiceImp.getSpecificProducts(idSet)).willReturn(productList);
        when(productServiceImp.getSpecificProducts(idSet)).thenReturn(productList);

        ObjectWriter ow = new ObjectMapper().writer();
        String content = ow.writeValueAsString(idListTemplate);

        MockHttpServletRequestBuilder mockBuilder = MockMvcRequestBuilders.post("/getSpecificProductDao")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockBuilder)
                .andReturn();

    }
    @Disabled
    @Test
    void getSpecificProductDao() {
    }
    @Disabled
    @Test
    void getSpecificProductDao2() {
    }
    @Disabled
    @Test
    void decreaseQuantity() {
    }
}