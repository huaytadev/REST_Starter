package com.rest_starter.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.rest_starter.dto.request.ProductFilterRequest;
import com.rest_starter.entity.Product;

import jakarta.persistence.criteria.Predicate;

public final class ProductSpecification {
	private ProductSpecification() {
    }

    public static Specification<Product> withFilters(ProductFilterRequest filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.name() != null && !filter.name().isBlank()) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("name")),
                                "%" + filter.name().toLowerCase() + "%"
                        )
                );
            }

            if (filter.category() != null && !filter.category().isBlank()) {
                predicates.add(
                        criteriaBuilder.equal(
                                criteriaBuilder.lower(root.get("category")),
                                filter.category().toLowerCase()
                        )
                );
            }

            if (filter.minPrice() != null) {
                predicates.add(
                        criteriaBuilder.greaterThanOrEqualTo(root.get("price"), filter.minPrice())
                );
            }

            if (filter.maxPrice() != null) {
                predicates.add(
                        criteriaBuilder.lessThanOrEqualTo(root.get("price"), filter.maxPrice())
                );
            }

            if (filter.active() != null) {
                predicates.add(
                        criteriaBuilder.equal(root.get("active"), filter.active())
                );
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
