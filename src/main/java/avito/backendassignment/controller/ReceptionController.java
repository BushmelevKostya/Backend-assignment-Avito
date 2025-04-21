package avito.backendassignment.controller;

import avito.backendassignment.controller.error.Error;
import avito.backendassignment.controller.request.ReceptionsPostRequest;
import avito.backendassignment.model.Reception;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping
public class ReceptionController {

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
    public ResponseEntity<Reception> receptionsPost(@Valid @RequestBody ReceptionsPostRequest request) {
        return null;
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
    public ResponseEntity<Reception> closeLastReception(@PathVariable UUID pvzId) {
        return null;
    }
}
