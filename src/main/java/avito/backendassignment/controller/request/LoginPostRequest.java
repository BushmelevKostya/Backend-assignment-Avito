package avito.backendassignment.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * LoginPostRequest
 */

@JsonTypeName("_login_post_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-21T05:51:18.622903100+03:00[Europe/Moscow]")
public class LoginPostRequest {
	
	private String email;
	
	private String password;
	
	public LoginPostRequest() {
		super();
	}
	
	/**
	 * Constructor with only required parameters
	 */
	public LoginPostRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public LoginPostRequest email(String email) {
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
	
	public LoginPostRequest password(String password) {
		this.password = password;
		return this;
	}
	
	/**
	 * Get password
	 *
	 * @return password
	 */
	@NotNull
	@Schema(name = "password", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("password")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LoginPostRequest loginPostRequest = (LoginPostRequest) o;
		return Objects.equals(this.email, loginPostRequest.email) &&
				Objects.equals(this.password, loginPostRequest.password);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email, password);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class LoginPostRequest {\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
		sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

