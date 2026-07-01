package com.rest_starter.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.rest_starter.dto.request.CreateProductRequest;
import com.rest_starter.dto.request.ProductFilterRequest;
import com.rest_starter.dto.request.UpdateProductRequest;
import com.rest_starter.dto.response.PageResponse;
import com.rest_starter.dto.response.ProductResponse;
import com.rest_starter.entity.Product;
import com.rest_starter.exception.ResourceNotFoundException;
import com.rest_starter.mapper.ProductMapper;
import com.rest_starter.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
	private static final Long PRODUCT_ID = 1L;
	
    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void create_shouldSaveProductAndReturnResponse() {
        CreateProductRequest request = new CreateProductRequest(
                "Keyboard",
                "Mechanical keyboard",
                BigDecimal.valueOf(100),
                10,
                "Peripherals"
        );

        Product product = product();
        ProductResponse response = productResponse();

        when(productMapper.toEntity(request)).thenReturn(product);
        when(productRepository.save(product)).thenReturn(product);
        when(productMapper.toResponse(product)).thenReturn(response);

        ProductResponse result = productService.create(request);

        assertEquals(response, result);
        verify(productRepository).save(product);
    }

    @Test
    void findById_shouldReturnProductWhenExists() {
        Product product = product();
        ProductResponse response = productResponse();

        when(productRepository.findById(PRODUCT_ID)).thenReturn(Optional.of(product));
        when(productMapper.toResponse(product)).thenReturn(response);

        ProductResponse result = productService.findById(PRODUCT_ID);

        assertEquals(response, result);
    }
    
    @Test
    void findById_shouldThrowResourceNotFoundException() {

        when(productRepository.findById(PRODUCT_ID))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> productService.findById(PRODUCT_ID)
        );
    }

    @Test
    void findAll_shouldReturnPagedProducts() {
        Product product = product();
        ProductResponse response = productResponse();
        ProductFilterRequest filter = new ProductFilterRequest(null, null, null, null, true);
        Pageable pageable = PageRequest.of(0, 10);

        when(productRepository.findAll(ArgumentMatchers.<Specification<Product>> any(), eq(pageable)))
        .thenReturn(new PageImpl<>(List.of(product), pageable, 1));

        when(productMapper.toResponse(product)).thenReturn(response);

        PageResponse<ProductResponse> result = productService.findAll(filter, pageable);

        assertEquals(1, result.content().size());
        assertEquals("Keyboard", result.content().get(0).name());
        assertEquals(1, result.totalElements());
    }

    @Test
    void update_shouldUpdateProductAndReturnResponse() {
        UpdateProductRequest request = new UpdateProductRequest(
                "Keyboard Pro",
                "Updated keyboard",
                BigDecimal.valueOf(150),
                5,
                "Peripherals",
                true
        );

        Product product = product();
        ProductResponse response = productResponse();

        when(productRepository.findById(PRODUCT_ID)).thenReturn(Optional.of(product));
        when(productRepository.save(product)).thenReturn(product);
        when(productMapper.toResponse(product)).thenReturn(response);

        ProductResponse result = productService.update(PRODUCT_ID, request);

        assertEquals(response, result);
        verify(productMapper).update(product, request);
        verify(productRepository).save(product);
    }
    
    @Test
    void update_shouldThrowResourceNotFoundException() {

        UpdateProductRequest request = new UpdateProductRequest(
                "Keyboard Pro",
                "Updated keyboard",
                BigDecimal.valueOf(150),
                5,
                "Peripherals",
                true
        );

        when(productRepository.findById(PRODUCT_ID))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> productService.update(PRODUCT_ID, request)
        );
    }

    @Test
    void partialUpdate_shouldUpdateOnlyProvidedFieldsAndReturnResponse() {
        UpdateProductRequest request = new UpdateProductRequest(
                "Keyboard Pro",
                null,
                null,
                null,
                null,
                null
        );

        Product product = product();
        ProductResponse response = productResponse();

        when(productRepository.findById(PRODUCT_ID)).thenReturn(Optional.of(product));
        when(productRepository.save(product)).thenReturn(product);
        when(productMapper.toResponse(product)).thenReturn(response);

        ProductResponse result = productService.partialUpdate(PRODUCT_ID, request);

        assertEquals(response, result);
        verify(productMapper).partialUpdate(product, request);
        verify(productRepository).save(product);
    }
    
    @Test
    void partialUpdate_shouldThrowResourceNotFoundException() {

        UpdateProductRequest request = new UpdateProductRequest(
                "Keyboard Pro",
                null,
                null,
                null,
                null,
                null
        );

        when(productRepository.findById(PRODUCT_ID))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> productService.partialUpdate(PRODUCT_ID, request)
        );
    }

    @Test
    void delete_shouldDeleteProductWhenExists() {
        Product product = product();

        when(productRepository.findById(PRODUCT_ID)).thenReturn(Optional.of(product));

        productService.delete(PRODUCT_ID);

        verify(productRepository).delete(product);
    }
    
    @Test
    void delete_shouldThrowResourceNotFoundException() {

        when(productRepository.findById(PRODUCT_ID))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> productService.delete(PRODUCT_ID)
        );
    }

    private Product product() {
        Product product = new Product();
        product.setId(PRODUCT_ID);
        product.setName("Keyboard");
        product.setDescription("Mechanical keyboard");
        product.setPrice(BigDecimal.valueOf(100));
        product.setStock(10);
        product.setCategory("Peripherals");
        product.setActive(true);
        product.setCreatedAt(Instant.now());
        product.setUpdatedAt(Instant.now());
        return product;
    }

    private ProductResponse productResponse() {
        return new ProductResponse(
        		PRODUCT_ID,
                "Keyboard",
                "Mechanical keyboard",
                BigDecimal.valueOf(100),
                10,
                "Peripherals",
                true,
                Instant.now(),
                Instant.now()
        );
    }
}
