package com.javaexpress.query.response;

import lombok.Data;

@Data
public class ProductDto {
	private String productId;
	private String title;
	private Double price;
	private Integer quantity;
}
