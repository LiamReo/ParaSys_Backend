package ch.ps_backend.controller;

import ch.ps_backend.dto.TimeLogDto;
import ch.ps_backend.model.TimeLog;
import ch.ps_backend.service.TimeLogService;
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
@RequestMapping("/addiction-logs")
public class TimeLogController {

    private final TimeLogService timeLogService;

    public TimeLogController(TimeLogService timeLogService) {
        this.timeLogService = timeLogService;
    }

    @Operation(summary = "Find all timeLogs.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "TimeLogs found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TimeLogDto.class))})})
    @GetMapping
    public List<TimeLogDto> findAll() {
        return timeLogService.getAll();
    }


    @Operation(summary = "Find a timeLog by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "TimeLog found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TimeLog.class))}),
            @ApiResponse(responseCode = "404", description = "TimeLog not found",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TimeLogDto.class))})
    })
    @GetMapping("{id}")
    public TimeLogDto findById(@Parameter(description = "Id of timeLog to get") @PathVariable Integer id) {
        try {
            return timeLogService.getById(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TimeLog could not be deleted");
        }
    }


    @Operation(summary = "Create a new timeLog.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "TimeLog was created successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TimeLogDto.class))}),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TimeLogDto.class))})
    })
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Parameter(description = "The new timeLog to create") @Valid @RequestBody TimeLogDto newTimeLog) {
        try {
            timeLogService.createOrUpdateTimeLog(newTimeLog);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }


    @Operation(summary = "Update a timeLog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "TimeLog was updated successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TimeLog.class))}),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TimeLog.class))})
    })
    @PutMapping(consumes = "application/json")
    public void update(@Parameter(description = "The timeLog to update") @Valid @RequestBody TimeLogDto timeLog) {
        try {
            timeLogService.createOrUpdateTimeLog(timeLog);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }


    @Operation(summary = "Delete a timeLog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "TimeLog was deleted successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TimeLog.class))}),
            @ApiResponse(responseCode = "404", description = "TimeLog could not be deleted",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TimeLog.class))})
    })
    @DeleteMapping("{id}")
    public void delete(@Parameter(description = "Id of timeLog to delete") @PathVariable Integer id) {
        try {
            timeLogService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TimeLog could not be deleted");
        }
    }
}
