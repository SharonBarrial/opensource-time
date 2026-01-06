package org.hign.platform.u202120418.personnel.interfaces.rest;/**
 * @author Fiorella Jarama Peñaloza
 * @version 1.0
 */

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hign.platform.u202120418.personnel.domain.services.ExaminerCommandService;
import org.hign.platform.u202120418.personnel.interfaces.rest.resources.CreateExaminerResource;
import org.hign.platform.u202120418.personnel.interfaces.rest.resources.ExaminerResource;
import org.hign.platform.u202120418.personnel.interfaces.rest.transform.CreateExaminerCommandFromResourceAssembler;
import org.hign.platform.u202120418.personnel.interfaces.rest.transform.ExaminerResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Descripción de la clase.
 *
 * @author Fiorella Jarama Peñaloza
 */
@RestController
@RequestMapping(value = "/api/v1/examiners", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Examiners", description = "Examiners Management Endpoints")
public class ExaminerController {

    private final ExaminerCommandService examinerCommandService;

    public ExaminerController(ExaminerCommandService examinerCommandService) {
        this.examinerCommandService = examinerCommandService;
    }

    @Operation(summary = "Create an examiner")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Examiner created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @PostMapping
    public ResponseEntity<ExaminerResource> createExaminer(@RequestBody CreateExaminerResource resource) {
        var createExaminerCommand = CreateExaminerCommandFromResourceAssembler.toCommandFromResource(resource);
        var examiner = examinerCommandService.handle(createExaminerCommand);
        if (examiner.isEmpty()) return ResponseEntity.badRequest().build();
        var agencyResource = ExaminerResourceFromEntityAssembler.toResourceFromEntity(examiner.get());
        return new ResponseEntity<>(agencyResource, HttpStatus.CREATED);
    }
}
