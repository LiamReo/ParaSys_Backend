package ch.ps_backend.controller;

import ch.ps_backend.dto.AmountLogDto;
import ch.ps_backend.model.AmountLog;
import ch.ps_backend.service.AmountLogService;
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
@RequestMapping("/amount-logs")
public class AmountLogController {

    private final AmountLogService amountLogService;

    public AmountLogController(AmountLogService amountLogService) {
        this.amountLogService = amountLogService;
    }

    @Operation(summary = "Find all amountLogs.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "AmountLogs found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AmountLogDto.class))})})
    @GetMapping
    public List<AmountLogDto> findAll() {
        return amountLogService.getAll();
    }


    @Operation(summary = "Find a amountLog by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "AmountLog found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AmountLog.class))}),
            @ApiResponse(responseCode = "404", description = "AmountLog not found",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AmountLogDto.class))})
    })
    @GetMapping("{id}")
    public AmountLogDto findById(@Parameter(description = "Id of amountLog to get") @PathVariable Integer id) {
        try {
            return amountLogService.getById(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AmountLog could not be deleted");
        }
    }


    @Operation(summary = "Create a new amountLog.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "AmountLog was created successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AmountLogDto.class))}),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AmountLogDto.class))})
    })
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Parameter(description = "The new amountLog to create") @Valid @RequestBody AmountLogDto newAmountLog) {
        try {
            amountLogService.createOrUpdateAmountLog(newAmountLog);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }


    @Operation(summary = "Update a amountLog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "AmountLog was updated successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AmountLog.class))}),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AmountLog.class))})
    })
    @PutMapping(consumes = "application/json")
    public void update(@Parameter(description = "The amountLog to update") @Valid @RequestBody AmountLogDto amountLog) {
        try {
            amountLogService.createOrUpdateAmountLog(amountLog);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }


    @Operation(summary = "Delete a amountLog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "AmountLog was deleted successfully",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AmountLog.class))}),
            @ApiResponse(responseCode = "404", description = "AmountLog could not be deleted",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Validation failed",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = AmountLog.class))})
    })
    @DeleteMapping("{id}")
    public void delete(@Parameter(description = "Id of amountLog to delete") @PathVariable Integer id) {
        try {
            amountLogService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AmountLog could not be deleted");
        }
    }
}
