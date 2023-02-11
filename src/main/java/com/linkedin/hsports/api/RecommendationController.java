package com.linkedin.hsports.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.linkedin.hsports.domain.Product;
import com.linkedin.hsports.services.ProductService;
import com.linkedin.hsports.services.RecommendationService;

@RestController
@RequestMapping("/recommendation")
public class RecommendationController {

	@Autowired
	private RecommendationService recommendationService;

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> findRecommendations(@PathVariable long productId){
	
		List<Product> recommendations = this.recommendationService.recommend(this.productService.getProduct(productId));
		return new ResponseEntity<>(recommendations, HttpStatus.OK);
	}

}
