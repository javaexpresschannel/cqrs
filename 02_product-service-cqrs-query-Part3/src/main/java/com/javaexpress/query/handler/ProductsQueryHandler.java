package com.javaexpress.query.handler;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaexpress.core.data.Product;
import com.javaexpress.core.data.ProductRepository;
import com.javaexpress.query.controller.FindProductsQuery;
import com.javaexpress.query.response.ProductDto;

@Component
public class ProductsQueryHandler {

	@Autowired
	private  ProductRepository productsRepository;
	
	@QueryHandler
	public List<ProductDto> findProducts(FindProductsQuery query) {
		System.out.println("ProductsQueryHandler executed");
		List<ProductDto> productsRest = new ArrayList<>();
		List<Product> storedProducts =  productsRepository.findAll();
		for(Product productEntity: storedProducts) {
			ProductDto productRestModel = new ProductDto();
			BeanUtils.copyProperties(productEntity, productRestModel);
			productsRest.add(productRestModel);
		}
		return productsRest;
		
	}
}
