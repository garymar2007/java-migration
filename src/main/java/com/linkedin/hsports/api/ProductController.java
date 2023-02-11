package com.linkedin.hsports.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.linkedin.hsports.domain.Product;
import com.linkedin.hsports.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public ResponseEntity<Product> findProduct(@PathVariable long productId){
		
		Product product = this.productService.getProduct(productId);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
}
