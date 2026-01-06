package org.hign.platform.u202120418.assessment.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hign.platform.u202120418.assessment.domain.services.MentalStateExamCommandService;
import org.hign.platform.u202120418.assessment.interfaces.rest.resources.CreateMentalStateExamResource;
import org.hign.platform.u202120418.assessment.interfaces.rest.resources.MentalStateExamResource;
import org.hign.platform.u202120418.assessment.interfaces.rest.transform.CreateMentalStateExamCommandFromResourceAssembler;
import org.hign.platform.u202120418.assessment.interfaces.rest.transform.MentalStateExamResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is the controller for the Mental State Examiner entity.
 *
 * @author Fiorella Jarama Peñaloza
 */
@RestController
@RequestMapping(value = "/api/v1/mental-state-exams", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Mental State Exams", description = "Mental State Exams Management Endpoints")
public class MentalStateExaminerController {

    private final MentalStateExamCommandService mentalStateExaminerCommandService;

    public MentalStateExaminerController(MentalStateExamCommandService mentalStateExaminerCommandService) {
        this.mentalStateExaminerCommandService = mentalStateExaminerCommandService;
    }

    /**
     * Create a mental state exam
     *
     * @param resource - CreateMentalStateExamResource
     * @return ResponseEntity<AgencyResource>
     */
    @Operation(summary = "Create a mental state exam")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Mental State Exam created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping
    public ResponseEntity<MentalStateExamResource> createMentalStateExam(@RequestBody CreateMentalStateExamResource resource) {
        var createMentalStateExam = CreateMentalStateExamCommandFromResourceAssembler.toCommandFromResource(resource);
        var mentalStateExam = mentalStateExaminerCommandService.handle(createMentalStateExam);
        if (mentalStateExam.isEmpty()) return ResponseEntity.badRequest().build();
        var agencyResource = MentalStateExamResourceFromEntityAssembler.toResourceFromEntity(mentalStateExam.get());
        return new ResponseEntity<>(agencyResource, HttpStatus.CREATED);
    }
}
