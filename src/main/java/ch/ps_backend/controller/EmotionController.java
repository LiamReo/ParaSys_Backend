package ch.ps_backend.controller;

import ch.ps_backend.dto.EmotionDto;
import ch.ps_backend.model.Emotion;
import ch.ps_backend.service.EmotionService;
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
@RequestMapping("/emotions")
public class EmotionController {

    private final EmotionService emotionService;

    public EmotionController(EmotionService emotionService) {
        this.emotionService = emotionService;
    }

    @Operation(summary = "Find all emotions.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Emotions found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmotionDto.class))})})
    @GetMapping
    public List<EmotionDto> findAll() {
        return emotionService.getAll();
    }


    @Operation(summary = "Find a emotion by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Emotion found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Emotion.class))}),
            @ApiResponse(responseCode = "404", description = "Emotion not found",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmotionDto.class))})
    })
    @GetMapping("{id}")
    public EmotionDto findById(@Parameter(description = "Id of emotion to get") @PathVariable Integer id) {
        try {
            return emotionService.getById(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Emotion could not be deleted");
        }
    }


    @Operation(summary = "Create a new emotion.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Emotion was created successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmotionDto.class))}),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmotionDto.class))})
    })
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Parameter(description = "The new emotion to create") @Valid @RequestBody EmotionDto newEmotion) {
        try {
            emotionService.createOrUpdateEmotion(newEmotion);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }


    @Operation(summary = "Update a emotion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Emotion was updated successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Emotion.class))}),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Emotion.class))})
    })
    @PutMapping(consumes = "application/json")
    public void update(@Parameter(description = "The emotion to update") @Valid @RequestBody EmotionDto emotion) {
        try {
            emotionService.createOrUpdateEmotion(emotion);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }


    @Operation(summary = "Delete a emotion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Emotion was deleted successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Emotion.class))}),
            @ApiResponse(responseCode = "404", description = "Emotion could not be deleted",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Emotion.class))})
    })
    @DeleteMapping("{id}")
    public void delete(@Parameter(description = "Id of emotion to delete") @PathVariable Integer id) {
        try {
            emotionService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Emotion could not be deleted");
        }
    }
}
