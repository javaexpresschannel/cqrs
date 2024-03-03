package com.javaexpress.command.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.command.dto.ProductDto;

@RestController
@RequestMapping("/product")
public class ProductCommandController {

	@Autowired
	private CommandGateway commandGateway;

	@PostMapping
	public String createProduct(@RequestBody ProductDto productDto) {
		CreateProductCommand createProductCommand = CreateProductCommand.builder()
													.productId(UUID.randomUUID().toString())
													.title(productDto.getTitle())
													.price(productDto.getPrice())
													.quantity(productDto.getQuantity())
													.build();
		// Send Command to Command Gateway
		String result = commandGateway.sendAndWait(createProductCommand);
		return result;
	}
}
