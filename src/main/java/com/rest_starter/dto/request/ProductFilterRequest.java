package com.rest_starter.dto.request;

import java.math.BigDecimal;

import com.rest_starter.validation.ValidPriceRange;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;

@ValidPriceRange
@Schema(description = "Query parameters used to filter products")
public record ProductFilterRequest(
        @Schema(description = "Filter by product name", example = "keyboard")
	    String name,
	    
        @Schema(description = "Filter by product category", example = "Peripherals")
	    String category,
	    
        @DecimalMin(value = "0.01", message = "Minimum price must be greater than or equal to 0.01")
        @Schema(description = "Minimun product price", example = "50")
	    BigDecimal minPrice,
	    
	    @DecimalMin(value = "0.01", message = "Maximum price must be greater than or equal to 0.01")
        @Schema(description = "Maximum product price", example = "200")
	    BigDecimal maxPrice,
	    
        @Schema(description = "Filter by active status", example = "true")
	    Boolean active
){}