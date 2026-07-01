package com.rest_starter.dto.response;

import java.math.BigDecimal;
import java.time.Instant;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Product response")
public record ProductResponse(
        @Schema(description = "Product ID", example = "1")
	    Long id,
	    
        @Schema(description = "Product name", example = "Mechanical Keyboard")
	    String name,
	    
        @Schema(description = "Product description", example = "RGB mechanical keyboard with blue switches")
	    String description,
	    
        @Schema(description = "Product price", example = "129.99")
	    BigDecimal price,
	    
        @Schema(description = "Available stock", example = "25")
	    Integer stock,
	    
        @Schema(description = "Product category", example = "Peripherals")
	    String category,
	    
        @Schema(description = "Whether the product is active", example = "true")
	    Boolean active,
	    
        @Schema(description = "Creation timestamp")
	    Instant createdAt,
	    
        @Schema(description = "Last update timestamp")
	    Instant updatedAt
){}
