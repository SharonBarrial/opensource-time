package org.hign.platform.u202120418.personnel.domain.model.aggregates;/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hign.platform.u202120418.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.u202120418.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.u202120418.personnel.domain.model.valueobjects.FirstName;
import org.hign.platform.u202120418.personnel.domain.model.valueobjects.LastName;
import org.hign.platform.u202120418.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import org.hign.platform.u202120418.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.util.HashSet;
import java.util.Set;

/**
 * Examiner - Represents the examiner in the personnel.
 *
 * @author Fiorella Jarama Peñaloza
 */
@Setter
@Getter
@Entity
public class Examiner extends AuditableAbstractAggregateRoot<Examiner> {

    @Embedded
    private FirstName firstName;

    @Embedded
    private LastName lastName;

    @Embedded
    private NationalProviderIdentifier nationalProviderIdentifier;

    @OneToMany(mappedBy = "evaluator", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MentalStateExam> evaluatedExams = new HashSet<>();

    public Examiner() {
    }

    public Examiner(FirstName firstName, LastName lastName, NationalProviderIdentifier nationalProviderIdentifier) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalProviderIdentifier = nationalProviderIdentifier;
    }

    public Examiner(CreateExaminerCommand command) {
        this.firstName = new FirstName(command.firstName());
        this.lastName = new LastName(command.lastName());
        this.nationalProviderIdentifier = new NationalProviderIdentifier(command.nationalProviderIdentifier());
    }

    //getters

    public String getFirstName() {
        return firstName.firstName();
    }

    public String getLastName() {
        return lastName.lastName();
    }

    public String getNationalProviderIdentifier() {
        return nationalProviderIdentifier.nationalProviderIdentifier();
    }

    public void setNationalProviderIdentifier(NationalProviderIdentifier nationalProviderIdentifier) {
        this.nationalProviderIdentifier = nationalProviderIdentifier;
    }

    public Set<MentalStateExam> getEvaluatedExams() {
        return evaluatedExams;
    }

    public void setEvaluatedExams(Set<MentalStateExam> evaluatedExams) {
        this.evaluatedExams = evaluatedExams;
    }
}
