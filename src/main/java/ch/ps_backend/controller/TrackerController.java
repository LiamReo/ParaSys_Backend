package ch.ps_backend.controller;

import ch.ps_backend.dto.TrackerDto;
import ch.ps_backend.model.Tracker;
import ch.ps_backend.service.TrackerService;
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
@RequestMapping("/trackers")
public class TrackerController {

    private final TrackerService trackerService;

    public TrackerController(TrackerService trackerService) {
        this.trackerService = trackerService;
    }

    @Operation(summary = "Find all trackers.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Trackers found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TrackerDto.class))})})
    @GetMapping
    public List<TrackerDto> findAll() {
        return trackerService.getAll();
    }


    @Operation(summary = "Find a tracker by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tracker found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Tracker.class))}),
            @ApiResponse(responseCode = "404", description = "Tracker not found",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TrackerDto.class))})
    })
    @GetMapping("{id}")
    public TrackerDto findById(@Parameter(description = "Id of tracker to get") @PathVariable Integer id) {
        try {
            return trackerService.getById(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tracker could not be deleted");
        }
    }


    @Operation(summary = "Create a new tracker.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tracker was created successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TrackerDto.class))}),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TrackerDto.class))})
    })
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Parameter(description = "The new tracker to create") @Valid @RequestBody TrackerDto newTracker) {
        try {
            trackerService.createOrUpdateTracker(newTracker);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }


    @Operation(summary = "Update a tracker")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tracker was updated successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Tracker.class))}),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Tracker.class))})
    })
    @PutMapping(consumes = "application/json")
    public void update(@Parameter(description = "The tracker to update") @Valid @RequestBody TrackerDto tracker) {
        try {
            trackerService.createOrUpdateTracker(tracker);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }


    @Operation(summary = "Delete a tracker")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tracker was deleted successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Tracker.class))}),
            @ApiResponse(responseCode = "404", description = "Tracker could not be deleted",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Tracker.class))})
    })
    @DeleteMapping("{id}")
    public void delete(@Parameter(description = "Id of tracker to delete") @PathVariable Integer id) {
        try {
            trackerService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tracker could not be deleted");
        }
    }
}
