package com.rest_starter.dto.request;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Query parameters used to filter products")
public record ProductFilterRequest(
        @Schema(description = "Filter by product name", example = "keyboard")
	    String name,
	    
        @Schema(description = "Filter by product category", example = "Peripherals")
	    String category,
	    
        @Schema(description = "Minimum product price", example = "50")
	    BigDecimal minPrice,
	    
        @Schema(description = "Maximum product price", example = "200")
	    BigDecimal maxPrice,
	    
        @Schema(description = "Filter by active status", example = "true")
	    Boolean active
){}