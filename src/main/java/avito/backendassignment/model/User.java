package avito.backendassignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;
import java.util.UUID;

/**
 * User
 */
 
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-21T05:51:18.622903100+03:00[Europe/Moscow]")
public class User {
	
	private UUID id;
	
	private String email;
	
	/**
	 * Gets or Sets role
	 */
	private RoleEnum role;
	
	public User() {
		super();
	}
	
	/**
	 * Constructor with only required parameters
	 */
	public User(String email, RoleEnum role) {
		this.email = email;
		this.role = role;
	}
	
	public User id(UUID id) {
		this.id = id;
		return this;
	}
	
	/**
	 * Get id
	 *
	 * @return id
	 */
	@Valid
	@Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("id")
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public User email(String email) {
		this.email = email;
		return this;
	}
	
	/**
	 * Get email
	 *
	 * @return email
	 */
	@NotNull
	@Email
	@Schema(name = "email", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("email")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public User role(RoleEnum role) {
		this.role = role;
		return this;
	}
	
	/**
	 * Get role
	 *
	 * @return role
	 */
	@NotNull
	@Schema(name = "role", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("role")
	public RoleEnum getRole() {
		return role;
	}
	
	public void setRole(RoleEnum role) {
		this.role = role;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		return Objects.equals(this.id, user.id) &&
				Objects.equals(this.email, user.email) &&
				Objects.equals(this.role, user.role);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, email, role);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class User {\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
		sb.append("    role: ").append(toIndentedString(role)).append("\n");
		sb.append("}");
		return sb.toString();
	}
	
	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}

