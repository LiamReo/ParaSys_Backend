package ch.ps_backend.controller;

import ch.ps_backend.dto.SoberTrackerDto;
import ch.ps_backend.model.SoberTracker;
import ch.ps_backend.service.SoberTrackerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@ApiResponses(value = {
        @ApiResponse(responseCode = "403", description = "You do not have permission to do this. Please use /login first.",
                content = {@Content(mediaType = "application/json")})})
@RestController
@RequestMapping("/sober-trackers")
public class SoberTrackerController {

    private final SoberTrackerService soberTrackerService;

    public SoberTrackerController(SoberTrackerService soberTrackerService) {
        this.soberTrackerService = soberTrackerService;
    }

    @Operation(summary = "Find all soberTrackers.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "SoberTrackers found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SoberTrackerDto.class))})})
    @GetMapping
    public List<SoberTrackerDto> findAll() {
        return soberTrackerService.getAll();
    }


    @Operation(summary = "Find a soberTracker by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "SoberTracker found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SoberTracker.class))}),
            @ApiResponse(responseCode = "404", description = "SoberTracker not found",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SoberTrackerDto.class))})
    })
    @GetMapping("{id}")
    public SoberTrackerDto findById(@Parameter(description = "Id of soberTracker to get") @PathVariable Integer id) {
        try {
            return soberTrackerService.getById(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "SoberTracker could not be deleted");
        }
    }


    @Operation(summary = "Create a new soberTracker.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "SoberTracker was created successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SoberTrackerDto.class))}),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SoberTrackerDto.class))})
    })
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Parameter(description = "The new soberTracker to create") @Valid @RequestBody SoberTrackerDto newSoberTracker) {
        try {
            soberTrackerService.createOrUpdateSoberTracker(newSoberTracker);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }


    @Operation(summary = "Update a soberTracker")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "SoberTracker was updated successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SoberTracker.class))}),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SoberTracker.class))})
    })
    @PutMapping(consumes = "application/json")
    public void update(@Parameter(description = "The soberTracker to update") @Valid @RequestBody SoberTrackerDto soberTracker) {
        try {
            soberTrackerService.createOrUpdateSoberTracker(soberTracker);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }


    @Operation(summary = "Delete a soberTracker")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "SoberTracker was deleted successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SoberTracker.class))}),
            @ApiResponse(responseCode = "404", description = "SoberTracker could not be deleted",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SoberTracker.class))})
    })
    @DeleteMapping("{id}")
    public void delete(@Parameter(description = "Id of soberTracker to delete") @PathVariable Integer id) {
        try {
            soberTrackerService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "SoberTracker could not be deleted");
        }
    }
}
