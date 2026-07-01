package com.rest_starter.entity;

import java.math.BigDecimal;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
	private Integer stock;
	private String category;
	private Boolean active;
	private Instant createdAt;
	private Instant updatedAt;
	
	@PrePersist
	public void prePersist() {
	    Instant now = Instant.now();
	    createdAt = now;
	    updatedAt = now;

	    if (active == null) {
	        active = true;
	    }
	}

	@PreUpdate
	public void preUpdate() {
	    updatedAt = Instant.now();
	}
}
