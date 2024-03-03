package com.javaexpress.command.controller;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProductCommand {

	@TargetAggregateIdentifier
	private final String productId;
	private final String title;
	private final Double price;
	private final Integer quantity;
	
}
