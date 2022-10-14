package com.TssCommerce.TssProduct;

import com.TssCommerce.TssProduct.Controller.ProductController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith( SpringExtension.class)
class TssProductApplicationTests {

	@Autowired
	ProductController productController;

	@Test
	void contextLoads() {
	}

}
