package avito.backendassignment.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;
import java.util.UUID;

/**
 * ReceptionsPostRequest
 */

@JsonTypeName("_receptions_post_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-21T05:51:18.622903100+03:00[Europe/Moscow]")
public class ReceptionsPostRequest {

  private UUID pvzId;

  public ReceptionsPostRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ReceptionsPostRequest(UUID pvzId) {
    this.pvzId = pvzId;
  }

  public ReceptionsPostRequest pvzId(UUID pvzId) {
    this.pvzId = pvzId;
    return this;
  }

  /**
   * Get pvzId
   * @return pvzId
  */
  @NotNull @Valid 
  @Schema(name = "pvzId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("pvzId")
  public UUID getPvzId() {
    return pvzId;
  }

  public void setPvzId(UUID pvzId) {
    this.pvzId = pvzId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReceptionsPostRequest receptionsPostRequest = (ReceptionsPostRequest) o;
    return Objects.equals(this.pvzId, receptionsPostRequest.pvzId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pvzId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReceptionsPostRequest {\n");
    sb.append("    pvzId: ").append(toIndentedString(pvzId)).append("\n");
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

