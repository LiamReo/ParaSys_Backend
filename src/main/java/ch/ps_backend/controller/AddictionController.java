package ch.ps_backend.controller;

import ch.ps_backend.dto.AddictionDto;
import ch.ps_backend.model.Addiction;
import ch.ps_backend.service.AddictionService;
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
@RequestMapping("/addictions")
public class AddictionController {

    private final AddictionService addictionService;

    public AddictionController(AddictionService addictionService) {
        this.addictionService = addictionService;
    }

    @Operation(summary = "Find all addictions.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Addictions found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AddictionDto.class))})})
    @GetMapping
    public List<AddictionDto> findAll() {
        return addictionService.getAll();
    }


    @Operation(summary = "Find a addiction by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Addiction found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Addiction.class))}),
            @ApiResponse(responseCode = "404", description = "Addiction not found",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AddictionDto.class))})
    })
    @GetMapping("{id}")
    public AddictionDto findById(@Parameter(description = "Id of addiction to get") @PathVariable Integer id) {
        try {
            return addictionService.getById(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Addiction could not be deleted");
        }
    }


    @Operation(summary = "Create a new addiction.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Addiction was created successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AddictionDto.class))}),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AddictionDto.class))})
    })
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Parameter(description = "The new addiction to create") @Valid @RequestBody AddictionDto newAddiction) {
        try {
            addictionService.createOrUpdateAddiction(newAddiction);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }


    @Operation(summary = "Update a addiction")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Addiction was updated successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Addiction.class))}),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Addiction.class))})
    })
    @PutMapping(consumes = "application/json")
    public void update(@Parameter(description = "The addiction to update") @Valid @RequestBody AddictionDto addiction) {
        try {
            addictionService.createOrUpdateAddiction(addiction);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }


    @Operation(summary = "Delete a addiction")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Addiction was deleted successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Addiction.class))}),
            @ApiResponse(responseCode = "404", description = "Addiction could not be deleted",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Addiction.class))})
    })
    @DeleteMapping("{id}")
    public void delete(@Parameter(description = "Id of addiction to delete") @PathVariable Integer id) {
        try {
            addictionService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Addiction could not be deleted");
        }
    }
}
