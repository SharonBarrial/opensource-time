package com.kaeser.platform.u202114900.analytics.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Symbol value object
 * <p>
 *     This class represents the symbol of a measurable indicator.
 *     It contains the symbol of the measurable indicator.
 *     It also contains the getter for the symbol of the measurable indicator.
 * </p>
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

@Embeddable
public record Symbol(String symbol) {
    public Symbol {
        if (symbol == null) {
            throw new IllegalArgumentException("Symbol must not be null");
        }
        if (symbol.isBlank()) {
            throw new IllegalArgumentException("Symbol must not be empty");
        }

    }

    public String GetSymbol() {
        return symbol;
    }
}
