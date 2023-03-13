package ch.ps_backend.controller;

import ch.ps_backend.dto.EmotionLogDto;
import ch.ps_backend.model.EmotionLog;
import ch.ps_backend.service.EmotionLogService;
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
@RequestMapping("/emotion-logs")
public class EmotionLogController {

    private final EmotionLogService emotionLogService;

    public EmotionLogController(EmotionLogService emotionLogService) {
        this.emotionLogService = emotionLogService;
    }

    @Operation(summary = "Find all emotionLogs.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "EmotionLogs found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmotionLogDto.class))})})
    @GetMapping
    public List<EmotionLogDto> findAll() {
        return emotionLogService.getAll();
    }


    @Operation(summary = "Find a emotionLog by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "EmotionLog found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmotionLog.class))}),
            @ApiResponse(responseCode = "404", description = "EmotionLog not found",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmotionLogDto.class))})
    })
    @GetMapping("{id}")
    public EmotionLogDto findById(@Parameter(description = "Id of emotionLog to get") @PathVariable Integer id) {
        try {
            return emotionLogService.getById(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "EmotionLog could not be deleted");
        }
    }


    @Operation(summary = "Create a new emotionLog.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "EmotionLog was created successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmotionLogDto.class))}),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmotionLogDto.class))})
    })
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Parameter(description = "The new emotionLog to create") @Valid @RequestBody EmotionLogDto newEmotionLog) {
        try {
            emotionLogService.createOrUpdateEmotionLog(newEmotionLog);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }


    @Operation(summary = "Update a emotionLog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "EmotionLog was updated successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmotionLog.class))}),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmotionLog.class))})
    })
    @PutMapping(consumes = "application/json")
    public void update(@Parameter(description = "The emotionLog to update") @Valid @RequestBody EmotionLogDto emotionLog) {
        try {
            emotionLogService.createOrUpdateEmotionLog(emotionLog);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }


    @Operation(summary = "Delete a emotionLog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "EmotionLog was deleted successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmotionLog.class))}),
            @ApiResponse(responseCode = "404", description = "EmotionLog could not be deleted",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmotionLog.class))})
    })
    @DeleteMapping("{id}")
    public void delete(@Parameter(description = "Id of emotionLog to delete") @PathVariable Integer id) {
        try {
            emotionLogService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "EmotionLog could not be deleted");
        }
    }
}
