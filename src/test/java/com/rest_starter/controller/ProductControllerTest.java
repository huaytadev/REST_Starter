package com.rest_starter.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest_starter.dto.request.CreateProductRequest;
import com.rest_starter.dto.request.PatchProductRequest;
import com.rest_starter.dto.request.ProductFilterRequest;
import com.rest_starter.dto.request.UpdateProductRequest;
import com.rest_starter.dto.response.PageResponse;
import com.rest_starter.dto.response.ProductResponse;
import com.rest_starter.exception.ResourceNotFoundException;
import com.rest_starter.service.ProductService;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

	private static final Long PRODUCT_ID = 1L;
	
    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @MockitoBean
    private ProductService productService;

    @Test
    void create_shouldReturnCreatedProduct() throws Exception {
        CreateProductRequest request = new CreateProductRequest(
                "Keyboard",
                "Mechanical keyboard",
                BigDecimal.valueOf(100),
                10,
                "Peripherals"
        );

        when(productService.create(any(CreateProductRequest.class))).thenReturn(productResponse());

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Keyboard"));
    }

    @Test
    void create_shouldReturnBadRequestWhenBodyIsInvalid() throws Exception {
        CreateProductRequest request = new CreateProductRequest(
                "",
                "Mechanical keyboard",
                BigDecimal.valueOf(100),
                10,
                "Peripherals"
        );

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void findById_shouldReturnProduct() throws Exception {
		when(productService.findById(PRODUCT_ID)).thenReturn(productResponse());

        mockMvc.perform(get("/api/products/{id}", PRODUCT_ID))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Keyboard"));
    }

    @Test
    void findAll_shouldReturnPagedProducts() throws Exception {
        PageResponse<ProductResponse> response = new PageResponse<>(
                List.of(productResponse()),
                0,
                10,
                1,
                1,
                true,
                true
        );

        when(productService.findAll(any(ProductFilterRequest.class), any(Pageable.class)))
                .thenReturn(response);

        mockMvc.perform(get("/api/products")
                        .param("page", "0")
                        .param("size", "10")
                        .param("sort", "id,asc")
                        .param("active", "true"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].id").value(1))
                .andExpect(jsonPath("$.content[0].name").value("Keyboard"))
                .andExpect(jsonPath("$.totalElements").value(1));
    }

    @Test
    void update_shouldReturnUpdatedProduct() throws Exception {
        UpdateProductRequest request = new UpdateProductRequest(
                "Keyboard Pro",
                "Updated keyboard",
                BigDecimal.valueOf(150),
                5,
                "Peripherals",
                true
        );

        when(productService.update(eq(PRODUCT_ID), any(UpdateProductRequest.class))).thenReturn(productResponse());

        mockMvc.perform(put("/api/products/{id}", PRODUCT_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }
    
    @Test
    void updateShouldReturn400WhenRequiredFieldsAreMissing() throws Exception {

        mockMvc.perform(put("/api/products/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "price": 150.00
                                }
                                """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.error").value("Bad Request"))
                .andExpect(jsonPath("$.message").value("Validation failed"));
    }

    @Test
    void partialUpdate_shouldReturnUpdatedProduct() throws Exception {
        ProductResponse response = new ProductResponse(
                1L,
                "Updated Product",
                "Updated description",
                new BigDecimal("150.00"),
                20,
                "Electronics",
                true,
                Instant.now(),
                Instant.now()
        );

        when(productService.partialUpdate(eq(1L), any(PatchProductRequest.class)))
                .thenReturn(response);

        mockMvc.perform(patch("/api/products/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "price": 150.00
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(150.00));
    }

    @Test
    void delete_shouldReturnNoContent() throws Exception {
        mockMvc.perform(delete("/api/products/{id}", PRODUCT_ID))
                .andExpect(status().isNoContent());

        verify(productService).delete(PRODUCT_ID);
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
    
    @Test
    void findByIdShouldReturn404WhenProductDoesNotExist() throws Exception {

        when(productService.findById(999L))
                .thenThrow(new ResourceNotFoundException("Product not found with id: 999"));

        mockMvc.perform(get("/api/products/999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.error").value("Not Found"))
                .andExpect(jsonPath("$.message")
                        .value("Product not found with id: 999"))
                .andExpect(jsonPath("$.path")
                        .value("/api/products/999"));
    }
}