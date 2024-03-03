package com.javaexpress.core.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreatedEvent {

	private String productId;
	private String title;
	private Double price;
	private Integer quantity;
}
