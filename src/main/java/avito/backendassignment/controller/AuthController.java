package avito.backendassignment.controller;

import avito.backendassignment.controller.request.DummyLoginPostRequest;
import avito.backendassignment.controller.request.LoginPostRequest;
import avito.backendassignment.controller.request.RegisterPostRequest;
import avito.backendassignment.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthController {
	
	@PostMapping(value = "/dummyLogin", consumes = "application/json", produces = "application/json")
	@Operation(
			operationId = "dummyLoginPost",
			summary = "Получение тестового токена",
			responses = {
					@ApiResponse(responseCode = "200", description = "Успешная авторизация",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
					@ApiResponse(responseCode = "400", description = "Неверный запрос",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class)))
			}
	)
	public ResponseEntity<String> dummyLoginPost(@Valid @RequestBody DummyLoginPostRequest dummyLoginPostRequest) {
		return null;
	}
	
	@PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
	@Operation(
			operationId = "loginPost",
			summary = "Авторизация пользователя",
			responses = {
					@ApiResponse(responseCode = "200", description = "Успешная авторизация",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
					@ApiResponse(responseCode = "401", description = "Неверные учетные данные",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class)))
			}
	)
	public ResponseEntity<String> loginPost(@Valid @RequestBody LoginPostRequest loginPostRequest) {
		return null;
	}
	
	@PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
	@Operation(
			operationId = "registerPost",
			summary = "Регистрация пользователя",
			responses = {
					@ApiResponse(responseCode = "201", description = "Пользователь создан",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
					@ApiResponse(responseCode = "400", description = "Неверный запрос",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class)))
			}
	)
	public ResponseEntity<User> registerPost(@Valid @RequestBody RegisterPostRequest registerPostRequest) {
		return null;
	}
}
