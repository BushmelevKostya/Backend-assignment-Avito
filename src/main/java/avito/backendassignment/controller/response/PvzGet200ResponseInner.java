package avito.backendassignment.controller.response;

import avito.backendassignment.model.PVZ;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PvzGet200ResponseInner
 */

@JsonTypeName("_pvz_get_200_response_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-21T05:51:18.622903100+03:00[Europe/Moscow]")
public class PvzGet200ResponseInner {

  private PVZ pvz;

  @Valid
  private List<@Valid PvzGet200ResponseInnerReceptionsInner> receptions;

  public PvzGet200ResponseInner pvz(PVZ pvz) {
    this.pvz = pvz;
    return this;
  }

  /**
   * Get pvz
   * @return pvz
  */
  @Valid 
  @Schema(name = "pvz", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pvz")
  public PVZ getPvz() {
    return pvz;
  }

  public void setPvz(PVZ pvz) {
    this.pvz = pvz;
  }

  public PvzGet200ResponseInner receptions(List<@Valid PvzGet200ResponseInnerReceptionsInner> receptions) {
    this.receptions = receptions;
    return this;
  }

  public PvzGet200ResponseInner addReceptionsItem(PvzGet200ResponseInnerReceptionsInner receptionsItem) {
    if (this.receptions == null) {
      this.receptions = new ArrayList<>();
    }
    this.receptions.add(receptionsItem);
    return this;
  }

  /**
   * Get receptions
   * @return receptions
  */
  @Valid 
  @Schema(name = "receptions", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("receptions")
  public List<@Valid PvzGet200ResponseInnerReceptionsInner> getReceptions() {
    return receptions;
  }

  public void setReceptions(List<@Valid PvzGet200ResponseInnerReceptionsInner> receptions) {
    this.receptions = receptions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PvzGet200ResponseInner pvzGet200ResponseInner = (PvzGet200ResponseInner) o;
    return Objects.equals(this.pvz, pvzGet200ResponseInner.pvz) &&
        Objects.equals(this.receptions, pvzGet200ResponseInner.receptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pvz, receptions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PvzGet200ResponseInner {\n");
    sb.append("    pvz: ").append(toIndentedString(pvz)).append("\n");
    sb.append("    receptions: ").append(toIndentedString(receptions)).append("\n");
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

