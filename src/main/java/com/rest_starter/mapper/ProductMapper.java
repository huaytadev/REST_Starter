package com.rest_starter.mapper;

import org.springframework.stereotype.Component;

import com.rest_starter.dto.request.CreateProductRequest;
import com.rest_starter.dto.request.UpdateProductRequest;
import com.rest_starter.dto.response.ProductResponse;
import com.rest_starter.entity.Product;

@Component
public class ProductMapper {
    public Product toEntity(CreateProductRequest request) {
        Product product = new Product();

        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());
        product.setStock(request.stock());
        product.setCategory(request.category());

        return product;
    }

    public ProductResponse toResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getCategory(),
                product.getActive(),
                product.getCreatedAt(),
                product.getUpdatedAt()
        );
    }

    public void update(Product product, UpdateProductRequest request) {
        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());
        product.setStock(request.stock());
        product.setCategory(request.category());
        product.setActive(request.active());
    }
    
    public void partialUpdate(Product product, UpdateProductRequest request) {
        if (request.name() != null) {
            product.setName(request.name());
        }

        if (request.description() != null) {
            product.setDescription(request.description());
        }

        if (request.price() != null) {
            product.setPrice(request.price());
        }

        if (request.stock() != null) {
            product.setStock(request.stock());
        }

        if (request.category() != null) {
            product.setCategory(request.category());
        }

        if (request.active() != null) {
            product.setActive(request.active());
        }

    }
}
