package com.linkedin.hsports.services;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.linkedin.hsports.HplusSportApiApplication;
import com.linkedin.hsports.domain.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HplusSportApiApplication.class)
public class ProductServiceTest {

	@Autowired
	private ProductService productService;

	@Test
	public void getProductTest() {
		
		Product product = this.productService.getProduct(524L);
		assertNotNull(product);
	}

}
