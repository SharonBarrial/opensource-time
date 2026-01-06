package com.kaeser.platform.ebpractice_2.analytics.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
@Embeddable
public record Symbol(String symbol) {

    public Symbol {
        if (symbol == null) {
            throw new IllegalArgumentException("Symbol cannot be null");
        }
        if (symbol.isBlank()) {
            throw new IllegalArgumentException("Symbol cannot be empty");
        }
    }

    public String getSymbol() {
        return symbol;
    }
}
