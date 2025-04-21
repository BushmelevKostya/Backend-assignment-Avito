package avito.backendassignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

/**
 * User
 */
@Table("users")
@Setter
@Getter
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-21T05:51:18.622903100+03:00[Europe/Moscow]")
public class User {
	@Id
	private Long id;
	
	@NotNull
	@Email
	private String email;
	
	private String password;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private RoleEnum role;
	
	public User() {
		super();
	}
	
	public User(String email, RoleEnum role) {
		this.email = email;
		this.role = role;
	}
}
