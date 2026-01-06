package com.isa.platform.u202120430.shared.domain.model.entities;

import com.isa.platform.u202120430.shared.domain.model.valueobjects.MonitoringLevelName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

/**
 * @author Nadia Alessandra Lucas Coronel - u202120430
 * @version 1.0
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class MonitoringLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private MonitoringLevelName level;

    public MonitoringLevel(MonitoringLevelName level) {
        this.level = level;
    }
}
