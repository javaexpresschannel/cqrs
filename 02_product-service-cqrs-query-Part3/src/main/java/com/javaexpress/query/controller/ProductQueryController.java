package com.javaexpress.query.controller;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.query.response.ProductDto;

@RestController
@RequestMapping("/products")
public class ProductQueryController {

	@Autowired
	QueryGateway queryGateway;
	
	@GetMapping
	public List<ProductDto> getProducts() {
		
		FindProductsQuery findProductsQuery = new FindProductsQuery();
		List<ProductDto> products = queryGateway.query(findProductsQuery,
				ResponseTypes.multipleInstancesOf(ProductDto.class)).join();
		
		return products;
		
		
	}
}
