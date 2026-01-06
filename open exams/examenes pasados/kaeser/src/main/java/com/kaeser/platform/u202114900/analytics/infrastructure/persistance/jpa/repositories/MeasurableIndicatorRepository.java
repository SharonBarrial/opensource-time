package com.kaeser.platform.u202114900.analytics.infrastructure.persistance.jpa.repositories;

import com.kaeser.platform.u202114900.analytics.domain.model.aggregates.MeasurableIndicator;
import com.kaeser.platform.u202114900.analytics.domain.model.valueobjects.Symbol;
import com.kaeser.platform.u202114900.shared.domain.model.entities.EquipmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * MeasurableIndicatorRepository interface
 * <p>
 *     This interface represents the repository for the measurable indicators.
 *     It extends the JpaRepository interface.
 *     It contains the method to check if a measurable indicator exists by its symbol and equipment type.
 * </p>
 * @author Sharon Antuanet Ivet Barrial Marin - u202114900
 * @version 1.0
 */

@Repository
public interface MeasurableIndicatorRepository extends JpaRepository<MeasurableIndicator, Long>{
    boolean existsBySymbolAndEquipmentType(Symbol symbol, EquipmentType equipmentType);
}
