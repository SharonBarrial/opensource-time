package com.kaeser.platform.ebpractice_2.analytics.infrastructure.persistence.jpa.repositories;

import com.kaeser.platform.ebpractice_2.analytics.domain.model.aggregates.MeasurableIndicator;
import com.kaeser.platform.ebpractice_2.analytics.domain.model.valueobjects.Symbol;
import com.kaeser.platform.ebpractice_2.inventory.domain.model.aggregates.Equipment;
import com.kaeser.platform.ebpractice_2.shared.domain.model.entities.EquipmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */
@Repository
public interface MeasurableIndicatorRepository extends JpaRepository<MeasurableIndicator, Long>  {
    boolean existsBySymbolAndEquipmentType(Symbol symbol, EquipmentType equipmentType);
}
