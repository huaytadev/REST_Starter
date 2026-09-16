package com.rest_starter.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.rest_starter.dto.request.CreateProductRequest;
import com.rest_starter.dto.request.PatchProductRequest;
import com.rest_starter.dto.request.ProductFilterRequest;
import com.rest_starter.dto.request.UpdateProductRequest;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class ProductValidationTest {
	
	private final Validator validator;
	
	public ProductValidationTest() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	void createProduct_shouldBeValidWhenAllFieldsAreCorrect() {
		CreateProductRequest request = new CreateProductRequest(
				"Keyboard", 
				"Mechanical Keyboard", 
				new BigDecimal("100.00"), 
				10, 
				"Peripherals"
		);
		
		Set<ConstraintViolation<CreateProductRequest>> violations = 
				validator.validate(request);
		assertEquals(0, violations.size());
	}
	
	@Test
	void createProduct_shouldRejectBlankName() {
		CreateProductRequest request = new CreateProductRequest(
				"", 
				"Mechanical Keyboard", 
				new BigDecimal("100.00"), 
				10, 
				"Peripherals"
		);
		Set<ConstraintViolation<CreateProductRequest>> violations = 
				validator.validate(request);
		assertEquals(1, violations.size());
	}
	
	@Test
	void createProduct_shouldRejectNullPrice() {
		CreateProductRequest request = new CreateProductRequest(
				"Keyboard", 
				"Mechanical Keyboard", 
				null, 
				10, 
				"Peripherals"
		);
		Set<ConstraintViolation<CreateProductRequest>> violations = 
				validator.validate(request);
		assertEquals(1, violations.size());
	}

    @Test
    void createProduct_shouldRejectInvalidPrice() {
		CreateProductRequest request = new CreateProductRequest(
				"Keyboard", 
				"Mechanical Keyboard", 
				BigDecimal.ZERO, 
				10, 
				"Peripherals"
		);
		Set<ConstraintViolation<CreateProductRequest>> violations = 
				validator.validate(request);
		assertEquals(1, violations.size());
    }
    
    @Test
    void createProduct_shouldRejectNegativeStock() {
		CreateProductRequest request = new CreateProductRequest(
				"Keyboard", 
				"Mechanical Keyboard", 
				new BigDecimal("100.00"), 
				-1, 
				"Peripherals"
		);
		Set<ConstraintViolation<CreateProductRequest>> violation =
				validator.validate(request);
		assertEquals(1, violation.size());
    }
    
    @Test
    void createProduct_shouldRejectBlankCategory() {
		CreateProductRequest request = new CreateProductRequest(
				"Keyboard", 
				"Mechanical Keyboard", 
				new BigDecimal("100.00"), 
				10, 
				""
		);
		Set<ConstraintViolation<CreateProductRequest>> violation = 
				validator.validate(request);
		assertEquals(1, violation.size());
    }
    
    @Test
    void createProduct_shouldRejectNameExceedingMaximumLength() {
    	String name = "a".repeat(101);

        CreateProductRequest request = new CreateProductRequest(
                name,
                "Mechanical keyboard",
                new BigDecimal("100.00"),
                10,
                "Peripherals"
        );
        Set<ConstraintViolation<CreateProductRequest>> violations =
                validator.validate(request);
        assertEquals(1, violations.size());
    }

    @Test
    void createProduct_shouldRejectDescriptionExceedingMaximumLength() {

        String description = "a".repeat(501);

        CreateProductRequest request = new CreateProductRequest(
                "Keyboard",
                description,
                new BigDecimal("100.00"),
                10,
                "Peripherals"
        );
        Set<ConstraintViolation<CreateProductRequest>> violations =
                validator.validate(request);
        assertEquals(1, violations.size());
    }

    @Test
    void createProduct_shouldRejectCategoryExceedingMaximumLength() {

        String category = "a".repeat(81);

        CreateProductRequest request = new CreateProductRequest(
                "Keyboard",
                "Mechanical keyboard",
                new BigDecimal("100.00"),
                10,
                category
        );
        Set<ConstraintViolation<CreateProductRequest>> violations =
                validator.validate(request);
        assertEquals(1, violations.size());
    }

    @Test
    void updateProduct_shouldRejectMissingRequiredFields() {

        UpdateProductRequest request = new UpdateProductRequest(
                null,
                null,
                null,
                null,
                null,
                null
        );
        Set<ConstraintViolation<UpdateProductRequest>> violations =
                validator.validate(request);
        assertEquals(5, violations.size());
    }

    @Test
    void patchProduct_shouldBeValidWhenFieldsAreNull() {

        PatchProductRequest request = new PatchProductRequest(
                null,
                null,
                null,
                null,
                null,
                null
        );
        Set<ConstraintViolation<PatchProductRequest>> violations =
                validator.validate(request);
        assertEquals(0, violations.size());
    }

    @Test
    void patchProduct_shouldRejectNegativePrice() {

        PatchProductRequest request = new PatchProductRequest(
                null,
                null,
                BigDecimal.ZERO,
                null,
                null,
                null
        );
        Set<ConstraintViolation<PatchProductRequest>> violations =
                validator.validate(request);
        assertEquals(1, violations.size());
    }

    @Test
    void patchProduct_shouldRejectNegativeStock() {

        PatchProductRequest request = new PatchProductRequest(
                null,
                null,
                null,
                -1,
                null,
                null
        );
        Set<ConstraintViolation<PatchProductRequest>> violations =
                validator.validate(request);
        assertEquals(1, violations.size());
    }

    @Test
    void productFilter_shouldBeValidWhenPriceRangeIsCorrect() {

        ProductFilterRequest request = new ProductFilterRequest(
                null,
                null,
                new BigDecimal("50.00"),
                new BigDecimal("100.00"),
                true
        );
        Set<ConstraintViolation<ProductFilterRequest>> violations =
                validator.validate(request);
        assertEquals(0, violations.size());
    }

    @Test
    void productFilter_shouldRejectWhenMinPriceIsGreaterThanMaxPrice() {

        ProductFilterRequest request = new ProductFilterRequest(
                null,
                null,
                new BigDecimal("200.00"),
                new BigDecimal("100.00"),
                true
        );
        Set<ConstraintViolation<ProductFilterRequest>> violations =
                validator.validate(request);
        assertEquals(1, violations.size());
    }

    @Test
    void productFilter_shouldAcceptOnlyMinPrice() {

        ProductFilterRequest request = new ProductFilterRequest(
                null,
                null,
                new BigDecimal("50.00"),
                null,
                true
        );

        Set<ConstraintViolation<ProductFilterRequest>> violations =
                validator.validate(request);
        assertEquals(0, violations.size());
    }

    @Test
    void productFilter_shouldAcceptOnlyMaxPrice() {

        ProductFilterRequest request = new ProductFilterRequest(
                null,
                null,
                null,
                new BigDecimal("100.00"),
                true
        );
        Set<ConstraintViolation<ProductFilterRequest>> violations =
                validator.validate(request);
        assertEquals(0, violations.size());
    }
}
