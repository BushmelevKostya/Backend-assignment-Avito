package avito.backendassignment.controller.request;

import avito.backendassignment.model.RoleEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * DummyLoginPostRequest
 */

@JsonTypeName("_dummyLogin_post_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-21T05:51:18.622903100+03:00[Europe/Moscow]")
public class DummyLoginPostRequest {

  /**
   * Gets or Sets role
   */
  

  private RoleEnum role;

  public DummyLoginPostRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DummyLoginPostRequest(RoleEnum role) {
    this.role = role;
  }

  public DummyLoginPostRequest role(RoleEnum role) {
    this.role = role;
    return this;
  }

  /**
   * Get role
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
    DummyLoginPostRequest dummyLoginPostRequest = (DummyLoginPostRequest) o;
    return Objects.equals(this.role, dummyLoginPostRequest.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DummyLoginPostRequest {\n");
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

