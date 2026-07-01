package com.rest_starter.service;

import org.springframework.data.domain.Pageable;

import com.rest_starter.dto.request.CreateProductRequest;
import com.rest_starter.dto.request.ProductFilterRequest;
import com.rest_starter.dto.request.UpdateProductRequest;
import com.rest_starter.dto.response.PageResponse;
import com.rest_starter.dto.response.ProductResponse;

public interface ProductService {
    ProductResponse create(CreateProductRequest request);

    ProductResponse findById(Long id);

    PageResponse<ProductResponse> findAll(ProductFilterRequest filter, Pageable pageable);

    ProductResponse update(Long id, UpdateProductRequest request);

    ProductResponse partialUpdate(Long id, UpdateProductRequest request);

    void delete(Long id);
}
