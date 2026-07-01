package com.rest_starter.service.impl;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest_starter.dto.request.CreateProductRequest;
import com.rest_starter.dto.request.ProductFilterRequest;
import com.rest_starter.dto.request.UpdateProductRequest;
import com.rest_starter.dto.response.PageResponse;
import com.rest_starter.dto.response.ProductResponse;
import com.rest_starter.entity.Product;
import com.rest_starter.exception.ResourceNotFoundException;
import com.rest_starter.mapper.ProductMapper;
import com.rest_starter.repository.ProductRepository;
import com.rest_starter.service.ProductService;
import com.rest_starter.specification.ProductSpecification;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional
    public ProductResponse create(CreateProductRequest request) {
        Product product = productMapper.toEntity(request);
        Product savedProduct = productRepository.save(product);
        
        return productMapper.toResponse(savedProduct);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponse findById(Long id) {
        Product product = getProductById(id);

        return productMapper.toResponse(product);
    }

    @Override
    @Transactional(readOnly = true)
    public PageResponse<ProductResponse> findAll(ProductFilterRequest filter, Pageable pageable) {
        return PageResponse.from(
        		productRepository.findAll(ProductSpecification.withFilters(filter), pageable)
        			.map(productMapper::toResponse)
        );
    }

    @Override
    @Transactional
    public ProductResponse update(Long id, UpdateProductRequest request) {
        Product product = getProductById(id);
        productMapper.update(product, request);
        Product updatedProduct = productRepository.save(product);

        return productMapper.toResponse(updatedProduct);
    }

    @Override
    @Transactional
    public ProductResponse partialUpdate(Long id, UpdateProductRequest request) {
        Product product = getProductById(id);
        productMapper.partialUpdate(product, request);
        Product updatedProduct = productRepository.save(product);

        return productMapper.toResponse(updatedProduct);
    }
    
    @Override
    @Transactional
    public void delete(Long id) {
        Product product = getProductById(id);

        productRepository.delete(product);
    }
    
    private Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }
}
