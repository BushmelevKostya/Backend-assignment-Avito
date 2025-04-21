package avito.backendassignment.controller;

import avito.backendassignment.controller.request.ProductsPostRequest;
import avito.backendassignment.model.Product;
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
public class ProductController {

    @PostMapping(value = "/products", consumes = "application/json", produces = "application/json")
    @Operation(
        operationId = "productsPost",
        summary = "Добавление товара в текущую приемку (только для сотрудников ПВЗ)",
        security = @SecurityRequirement(name = "bearerAuth"),
        responses = {
            @ApiResponse(responseCode = "201", description = "Товар добавлен",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class))),
            @ApiResponse(responseCode = "400", description = "Неверный запрос или нет активной приемки",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
            @ApiResponse(responseCode = "403", description = "Доступ запрещен",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class)))
        }
    )
    public ResponseEntity<Product> productsPost(@Valid @RequestBody ProductsPostRequest request) {
        return null;
    }

    @PostMapping(value = "/pvz/{pvzId}/delete_last_product", produces = "application/json")
    @Operation(
        operationId = "pvzPvzIdDeleteLastProductPost",
        summary = "Удаление последнего добавленного товара из текущей приемки",
        security = @SecurityRequirement(name = "bearerAuth"),
        responses = {
            @ApiResponse(responseCode = "200", description = "Товар удален"),
            @ApiResponse(responseCode = "400", description = "Неверный запрос",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
            @ApiResponse(responseCode = "403", description = "Доступ запрещен",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class)))
        }
    )
    public ResponseEntity<Void> deleteLastProduct(@PathVariable UUID pvzId) {
        return null;
    }
}
