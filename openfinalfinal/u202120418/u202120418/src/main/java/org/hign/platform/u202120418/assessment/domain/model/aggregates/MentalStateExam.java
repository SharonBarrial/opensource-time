package org.hign.platform.u202120418.assessment.domain.model.aggregates;/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hign.platform.u202120418.assessment.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.u202120418.assessment.domain.model.valueobjects.*;
import org.hign.platform.u202120418.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u202120418.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

/**
 * MentalStateExam - Represents the mental state exam of a patient.
 *
 * @author Fiorella Jarama Peñaloza
 */
@Setter
@Getter
@Entity
public class MentalStateExam extends AuditableAbstractAggregateRoot<MentalStateExam> {

    @Embedded
    private PatientId patientId;

    @Embedded
    private ExamDate examDate;

    @Embedded
    private OrientationScore orientationScore;

    @Embedded
    private AttentionAndCalculationScore attentionAndCalculationScore;

    @Embedded
    private RegistrationScore registrationScore;

    @Embedded
    private RecallScore recallScore;

    @Embedded
    private LanguageScore languageScore;

    @ManyToOne(optional = false)
    @JoinColumn(name = "examinerNationalProviderIdentifier", nullable = false)
    private Examiner evaluator;


    public MentalStateExam(PatientId patientId, ExamDate examDate, OrientationScore orientationScore, AttentionAndCalculationScore attentionAndCalculationScore, RegistrationScore registrationScore, RecallScore recallScore, LanguageScore languageScore, Examiner evaluator) {
        this.patientId = patientId;
        this.examDate = examDate;
        this.orientationScore = orientationScore;
        this.attentionAndCalculationScore = attentionAndCalculationScore;
        this.registrationScore = registrationScore;
        this.recallScore = recallScore;
        this.languageScore = languageScore;
        this.evaluator = evaluator;
    }

    public MentalStateExam(CreateMentalStateExamCommand command, Examiner evaluator) {
        this.patientId = new PatientId(command.patientId());
        this.examDate = new ExamDate(command.examDate());
        this.orientationScore = new OrientationScore(command.orientationScore());
        this.attentionAndCalculationScore = new AttentionAndCalculationScore(command.attentionAndCalculationScore());
        this.registrationScore = new RegistrationScore(command.registrationScore());
        this.recallScore = new RecallScore(command.recallScore());
        this.languageScore = new LanguageScore(command.languageScore());
        this.evaluator = evaluator;
    }

    public MentalStateExam() {

    }

    public Long getPatientId() {
        return patientId.patientId();
    }

    public String getExamDate() {
        return examDate.examDate();
    }

    public int getOrientationScore() {
        return orientationScore.orientationScore();
    }

    public int getAttentionAndCalculationScore() {
        return attentionAndCalculationScore.attentionAndCalculationScore();
    }

    public int getRegistrationScore() {
        return registrationScore.registrationScore();
    }

    public int getRecallScore() {
        return recallScore.recallScore();
    }

    public int getLanguageScore() {
        return languageScore.languageScore();
    }

    public String getExaminer() {
        return evaluator.getNationalProviderIdentifier();
    }

    public void setExaminer(Examiner evaluator) {
        this.evaluator = evaluator;
    }

}
