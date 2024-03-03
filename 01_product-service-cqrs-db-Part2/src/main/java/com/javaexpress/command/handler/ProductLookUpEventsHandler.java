package com.javaexpress.command.handler;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaexpress.core.data.ProductLookupEntity;
import com.javaexpress.core.data.ProductLookupRepository;
import com.javaexpress.core.events.ProductCreatedEvent;

@Component
//@ProcessingGroup("product-group")
public class ProductLookUpEventsHandler {

	@Autowired
	private ProductLookupRepository productLookupRepository;
	
	@EventHandler
	public void on(ProductCreatedEvent event) {
		ProductLookupEntity productLookupEntity = new ProductLookupEntity(event.getProductId(),
				event.getTitle());
		try {
			productLookupRepository.save(productLookupEntity);
		}catch(Throwable ex) {
			
		}
		
	}
}

