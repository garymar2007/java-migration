package com.linkedin.hsports.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkedin.hsports.domain.Product;

import sun.misc.BASE64Decoder;

@Service
public class RecommendationService {

	@Autowired
	private RecommendationConfiguration config;

	@Autowired
	private ProductService productService;

	private static final String licenseKey = "abcdefg";

	public List<Product> recommend(Product product) {

		List<Product> results = new ArrayList<>();
		List<Product> products = this.productService.getProducts();
		BASE64Decoder decoder = new BASE64Decoder();

		try {
			String key = new String(decoder.decodeBuffer(this.config.getLicenseKey()));
			System.out.println(key);
			if (licenseKey.equals(key)) {
				results = products.subList(products.indexOf(product) + 1, this.config.getRecommendationNumber() - 1);
			}
		} catch (Exception e) {
			//Disregard io and overflow
			e.printStackTrace();
		}

		return results;

	}
	
}
