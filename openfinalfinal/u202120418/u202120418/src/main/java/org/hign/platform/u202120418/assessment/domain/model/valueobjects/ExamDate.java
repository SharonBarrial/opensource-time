package org.hign.platform.u202120418.assessment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Record para la fecha de examen, embebido en la entidad Examiner.
 * Acepta una fecha como String con el formato YYYY-MM-DD.
 * @autor Fiorella Jarama Peñaloza
 * @version 1.0
 */
@Embeddable
public record ExamDate(String examDate) {
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public ExamDate {
        if (examDate == null || examDate.isBlank()) {
            throw new IllegalArgumentException("ExamDate cannot be null or blank");
        }

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setLenient(false); // No permitir fechas inválidas

        try {
            Date date = sdf.parse(examDate);

            // Validar que la fecha no sea posterior a la fecha actual
            if (date.after(new Date())) {
                throw new IllegalArgumentException("Exam date cannot be in the future");
            }

            if (!examDate.equals(sdf.format(date))) {
                throw new IllegalArgumentException("Invalid date format. Expected format is YYYY-MM-DD");
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format. Expected format is YYYY-MM-DD", e);
        }
    }
}
