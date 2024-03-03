package com.javaexpress.command.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.javaexpress.command.controller.CreateProductCommand;
import com.javaexpress.core.events.ProductCreatedEvent;

@Aggregate
public class ProductAggregate {

	@AggregateIdentifier
	private String productId;
	private String title;
	private Double price;
	private Integer quantity;
	
	public ProductAggregate() {
		// TODO Auto-generated constructor stub
	}
	
	@CommandHandler
	public ProductAggregate(CreateProductCommand createProductCommand) {
		ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent();
		BeanUtils.copyProperties(createProductCommand, productCreatedEvent);
		AggregateLifecycle.apply(productCreatedEvent);
	}
	
	@EventSourcingHandler
	public void on(ProductCreatedEvent productCreatedEvent) {
		this.productId = productCreatedEvent.getProductId();
		this.title = productCreatedEvent.getTitle();
		this.price = productCreatedEvent.getPrice();
		this.quantity = productCreatedEvent.getQuantity();
	}
	
	
}
