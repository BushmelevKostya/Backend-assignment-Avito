package avito.backendassignment.controller;

import avito.backendassignment.controller.request.DummyLoginPostRequest;
import avito.backendassignment.controller.request.LoginPostRequest;
import avito.backendassignment.controller.request.RegisterPostRequest;
import avito.backendassignment.model.User;
import avito.backendassignment.model.RoleEnum;
import avito.backendassignment.service.CustomUserDetailsService;
import avito.backendassignment.util.JwtTokenUtil;
import avito.backendassignment.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping
public class AuthController {
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private CustomUserDetailsService userDetailsService;
	@Autowired
	private UserService userService;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
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
	public ResponseEntity<Map<String, String>> dummyLoginPost(@Valid @RequestBody DummyLoginPostRequest dummyLoginPostRequest) {
		String token = jwtTokenUtil.generateToken(userDetailsService.loadUserByRole("dummy"), dummyLoginPostRequest.getRole().toString());
		return ResponseEntity.ok(Map.of("token", token));
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
		try {
			authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
					loginPostRequest.getEmail(), 
					loginPostRequest.getPassword()
				)
			);
		} catch (BadCredentialsException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(loginPostRequest.getEmail());
		final String token = jwtTokenUtil.generateToken(userDetails, "USER");
		
		return ResponseEntity.ok(token);
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
		if (userService.existsByEmail(registerPostRequest.getEmail())) {
			return ResponseEntity.badRequest().build();
		}
		
		User newUser = new User();
		newUser.setEmail(registerPostRequest.getEmail());
		newUser.setPassword(registerPostRequest.getPassword());
		newUser.setRole(RoleEnum.EMPLOYEE);

		User createdUser = userService.createUser(newUser);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}
}
