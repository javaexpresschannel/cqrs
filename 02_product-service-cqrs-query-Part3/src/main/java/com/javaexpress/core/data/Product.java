package com.javaexpress.core.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="products")
@Data
public class Product {

	@Id
	@Column(unique=true)
	private String productId;
	
	private String title;
	private Double price;
	private Integer quantity;
}
