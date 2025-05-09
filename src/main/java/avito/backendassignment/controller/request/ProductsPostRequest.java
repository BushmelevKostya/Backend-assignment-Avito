package avito.backendassignment.controller.request;

import avito.backendassignment.model.TypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * ProductsPostRequest
 */

@JsonTypeName("_products_post_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-21T05:51:18.622903100+03:00[Europe/Moscow]")
public class ProductsPostRequest {

  private TypeEnum type;

  private Long pvzId;

  public ProductsPostRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ProductsPostRequest(TypeEnum type, Long pvzId) {
    this.type = type;
    this.pvzId = pvzId;
  }

  public ProductsPostRequest type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @NotNull 
  @Schema(name = "type", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public ProductsPostRequest pvzId(Long pvzId) {
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
  public Long getPvzId() {
    return pvzId;
  }

  public void setPvzId(Long pvzId) {
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
    ProductsPostRequest productsPostRequest = (ProductsPostRequest) o;
    return Objects.equals(this.type, productsPostRequest.type) &&
        Objects.equals(this.pvzId, productsPostRequest.pvzId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, pvzId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductsPostRequest {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

