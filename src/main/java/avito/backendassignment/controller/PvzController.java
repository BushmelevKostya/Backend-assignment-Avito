package avito.backendassignment.controller;

import avito.backendassignment.controller.response.PvzGet200ResponseInner;
import avito.backendassignment.exceptions.InvalidCityException;
import avito.backendassignment.model.PVZ;
import avito.backendassignment.service.PvzService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PvzController {
	
	private final PvzService pvzService;
	
	@GetMapping(value = "/pvz", produces = "application/json")
	@Operation(
			operationId = "pvzGet",
			summary = "Получение списка ПВЗ с фильтрацией по дате",
			security = @SecurityRequirement(name = "bearerAuth"),
			responses = @ApiResponse(responseCode = "200", description = "Список ПВЗ",
					content = @Content(mediaType = "application/json",
							array = @ArraySchema(schema = @Schema(implementation = PvzGet200ResponseInner.class)))))
	public ResponseEntity<List<PvzGet200ResponseInner>> getPvzList(
			@RequestParam(value = "startDate", required = false)
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime startDate,
			@RequestParam(value = "endDate", required = false)
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime endDate,
			@RequestParam(value = "page", required = false, defaultValue = "1") @Min(1) Integer page,
			@RequestParam(value = "limit", required = false, defaultValue = "10") @Min(1) @Max(30) Integer limit
	) {
		List<PvzGet200ResponseInner> pvzList = pvzService.getPvzList(startDate, endDate, page, limit);
		return ResponseEntity.ok(pvzList);
	}
	
	@PostMapping(value = "/pvz", consumes = "application/json", produces = "application/json")
	@Operation(
			operationId = "pvzPost",
			summary = "Создание ПВЗ (только для модераторов)",
			security = @SecurityRequirement(name = "bearerAuth"),
			responses = {
					@ApiResponse(responseCode = "201", description = "ПВЗ создан",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = PVZ.class))),
					@ApiResponse(responseCode = "400", description = "Неверный запрос",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))),
					@ApiResponse(responseCode = "403", description = "Доступ запрещен",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class)))
			}
	)
	@PreAuthorize("hasRole('MODERATOR')")
	public ResponseEntity<PVZ> createPvz(@Valid @RequestBody PVZ pvz) {
		if (!isValidCity(String.valueOf(pvz.getCity()))) {
			throw new InvalidCityException("ПВЗ можно создавать только в Москве, Санкт-Петербурге или Казани");
		}
		
		PVZ createdPvz = pvzService.createPvz(pvz);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdPvz);
	}
	
	private boolean isValidCity(String city) {
		return city != null &&
				(city.equals("Москва") ||
						city.equals("Санкт-Петербург") ||
						city.equals("Казань"));
	}
}