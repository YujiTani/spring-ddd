package com.teckbook.domain.model;

import jakarta.persistence.Embeddable;

import java.math.BigDecimal;
import java.time.LocalDate;

@Embeddable
public record PurchaseInfo(
        LocalDate purchaseDate,
        BigDecimal price,
        String storeName) {

    public PurchaseInfo {
        if (purchaseDate == null) {
            throw new IllegalArgumentException("Purchase date cannot be null");
        }

        if (price != null && price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }

        if (storeName == null || storeName.isBlank()) {
            throw new IllegalArgumentException("Store name cannot be null or blank");
        }
    }
}
