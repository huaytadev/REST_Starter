package com.rest_starter.dto.request;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Request body used to create a product")
public record CreateProductRequest(
		@Schema(description = "Product name", example = "Mechanical Keyboard")
        @NotBlank(message = "Product name is required")
        @Size(max = 100, message = "Product name must not exceed 100 characters")
		String name,
		
        @Schema(description = "Product description", example = "RGB mechanical keyboard with blue switches")
        @Size(max = 500, message = "Product description must not exceed 500 characters")
		String description,
		
        @Schema(description = "Product price", example = "129.99")
        @NotNull(message = "Product price is required")
        @DecimalMin(value = "0.01", message = "Product price must be greater than 0")
		BigDecimal price,
		
        @Schema(description = "Available stock", example = "25")
        @NotNull(message = "Product stock is required")
        @Min(value = 0, message = "Product stock must be greater than or equal to 0")
		Integer stock,
		
		@Schema(description = "Product category", example = "Peripherals")
        @NotBlank(message = "Product category is required")
        @Size(max = 80, message = "Product category must not exceed 80 characters")
		String category
) {}