package avito.backendassignment.controller;

import avito.backendassignment.controller.error.Error;
import avito.backendassignment.controller.request.ReceptionsPostRequest;
import avito.backendassignment.model.Reception;
import avito.backendassignment.service.ReceptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ReceptionController {
    
    private final ReceptionService receptionService;
    
    @PostMapping(value = "/receptions", consumes = "application/json", produces = "application/json")
    @Operation(
            operationId = "receptionsPost",
            summary = "Создание новой приемки товаров",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Приемка создана",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Reception.class))),
                    @ApiResponse(responseCode = "400", description = "Неверный запрос",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
                    @ApiResponse(responseCode = "403", description = "Доступ запрещен",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class)))
            }
    )
    @PreAuthorize("hasRole('EMPLOYEE')")
    public ResponseEntity<Reception> createReception(@Valid @RequestBody ReceptionsPostRequest request) {
        Reception reception = receptionService.createReception(request.getPvzId());
        return ResponseEntity.status(201).body(reception);
    }
    
    @PostMapping(value = "/pvz/{pvzId}/close_last_reception", produces = "application/json")
    @Operation(
            operationId = "pvzPvzIdCloseLastReceptionPost",
            summary = "Закрытие последней открытой приемки",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Приемка закрыта",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Reception.class))),
                    @ApiResponse(responseCode = "400", description = "Неверный запрос",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
                    @ApiResponse(responseCode = "403", description = "Доступ запрещен",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class)))
            }
    )
    @PreAuthorize("hasRole('EMPLOYEE')")
    public ResponseEntity<Reception> closeLastReception(@PathVariable Long pvzId) {
        Reception reception = receptionService.closeLastReception(pvzId);
        return ResponseEntity.ok(reception);
    }
}