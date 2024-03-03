package com.javaexpress.core.events;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaexpress.core.data.Product;
import com.javaexpress.core.data.ProductRepository;

@Component
//@ProcessingGroup("product-group")
public class ProductEventsHandler {

	@Autowired
	private ProductRepository productRepository;
	
	@EventHandler
	public void on(ProductCreatedEvent event) {
		System.out.println("ProductEventsHandler executed");
		Product productEntity = new Product();
		BeanUtils.copyProperties(event, productEntity);

		try {
			productRepository.save(productEntity);
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
		}

	}
}
