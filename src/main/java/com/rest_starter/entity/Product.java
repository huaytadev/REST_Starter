package com.rest_starter.entity;

import java.math.BigDecimal;
import java.time.Instant;

import jakarta.persistence.Column;
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
	@Column(nullable = false, length = 100)
	private String name;
	@Column(length = 500)
	private String description;
	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal price;
	@Column(nullable = false)
	private Integer stock;
	@Column(nullable = false, length = 80)
	private String category;
	@Column(nullable = false)
	private Boolean active;
	@Column(nullable = false, updatable = false)
	private Instant createdAt;
	@Column(nullable = false)
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
