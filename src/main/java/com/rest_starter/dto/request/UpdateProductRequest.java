package com.rest_starter.dto.request;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Schema(description = "Request body used to update a product")
public record UpdateProductRequest(
		@Schema(description = "Product name", example = "Mechanical Keyboard Pro")
        @Size(max = 100, message = "Product name must not exceed 100 characters")
		String name,
		
		@Schema(description = "Product description", example = "Updated RGB mechanical keyboard")
        @Size(max = 500, message = "Product description must not exceed 500 characters")
	    String description,
	    
	    @Schema(description = "Product price", example = "149.99")
        @DecimalMin(value = "0.01", message = "Product price must be greater than 0")
	    BigDecimal price,
	    
	    @Schema(description = "Available stock", example = "15")
        @Min(value = 0, message = "Product stock must be greater than or equal to 0")
	    Integer stock,
	    
	    @Schema(description = "Product category", example = "Peripherals")
        @Size(max = 80, message = "Product category must not exceed 80 characters")
	    String category,
	    
        @Schema(description = "Whether the product is active", example = "true")
	    Boolean active
) {}
