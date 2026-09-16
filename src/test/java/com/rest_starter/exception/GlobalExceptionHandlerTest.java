package com.rest_starter.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import com.rest_starter.dto.response.ErrorResponse;

import jakarta.persistence.EntityNotFoundException;

public class GlobalExceptionHandlerTest {
    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void handleResourceNotFound_shouldReturn404() {

        ResourceNotFoundException exception =
                new ResourceNotFoundException("Product not found");

        MockHttpServletRequest request = request("/api/products/1");

        ResponseEntity<ErrorResponse> response = handler.handleResourceNotFound(exception, request);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNotNull(response.getBody());

        assertEquals(404, response.getBody().status());
        assertEquals("Not Found", response.getBody().error());
        assertEquals("Product not found", response.getBody().message());
        assertEquals("/api/products/1", response.getBody().path());
    }

    @Test
    void handleEntityNotFound_shouldReturn404() {

        EntityNotFoundException exception = new EntityNotFoundException("Entity not found");

        MockHttpServletRequest request = request("/api/products/1");

        ResponseEntity<ErrorResponse> response = handler.handleEntityNotFoundException(exception, request);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNotNull(response.getBody());

        assertEquals(404, response.getBody().status());
        assertEquals("Not Found", response.getBody().error());
        assertEquals("Entity not found", response.getBody().message());
    }

    @Test
    void handleDataIntegrityViolation_shouldReturn409() {

        DataIntegrityViolationException exception = new DataIntegrityViolationException("Constraint violated");

        MockHttpServletRequest request = request("/api/products");

        ResponseEntity<ErrorResponse> response = handler.handleDataIntegrityViolation(exception, request);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertNotNull(response.getBody());

        assertEquals(409, response.getBody().status());
        assertEquals("Conflict", response.getBody().error());
        assertEquals("Database constraint violated.", response.getBody().message());
    }

    @Test
    void handleIllegalArgument_shouldReturn400() {

        IllegalArgumentException exception = new IllegalArgumentException("Invalid argument");

        MockHttpServletRequest request = request("/api/products");

        ResponseEntity<ErrorResponse> response = handler.handleIllegalArgument(exception, request);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());

        assertEquals(400, response.getBody().status());
        assertEquals("Bad Request", response.getBody().error());
        assertEquals("Invalid argument", response.getBody().message());
    }

    @Test
    void handleGenericException_shouldReturn500() {

        Exception exception = new Exception("Internal error");

        MockHttpServletRequest request = request("/api/products");

        ResponseEntity<ErrorResponse> response = handler.handleGenericException(exception, request);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

        assertNotNull(response.getBody());

        assertEquals(500, response.getBody().status());
        assertEquals("Internal Server Error", response.getBody().error());
        assertEquals("Unexpected error occurred",response.getBody().message());
    }

    private MockHttpServletRequest request(String uri) {

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI(uri);
        return request;
    }
}
