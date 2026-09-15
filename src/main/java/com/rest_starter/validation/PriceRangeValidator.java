package com.rest_starter.validation;

import java.math.BigDecimal;

import com.rest_starter.dto.request.ProductFilterRequest;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PriceRangeValidator implements ConstraintValidator<ValidPriceRange, ProductFilterRequest>{
    @Override
    public boolean isValid(ProductFilterRequest filter, ConstraintValidatorContext context) {
        
    	if (filter == null) {
            return true;
        }

        BigDecimal minPrice = filter.minPrice();
        BigDecimal maxPrice = filter.maxPrice();

        if (minPrice == null || maxPrice == null) {
            return true;
        }

        return minPrice.compareTo(maxPrice) <= 0;
    }
}
