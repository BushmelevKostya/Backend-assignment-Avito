package avito.backendassignment.controller.response;

import avito.backendassignment.model.Product;
import avito.backendassignment.model.Reception;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PvzGet200ResponseInnerReceptionsInner
 */

@JsonTypeName("_pvz_get_200_response_inner_receptions_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-21T05:51:18.622903100+03:00[Europe/Moscow]")
public class PvzGet200ResponseInnerReceptionsInner {

  private Reception reception;

  @Valid
  private List<@Valid Product> products;

  public PvzGet200ResponseInnerReceptionsInner reception(Reception reception) {
    this.reception = reception;
    return this;
  }

  /**
   * Get reception
   * @return reception
  */
  @Valid 
  @Schema(name = "reception", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("reception")
  public Reception getReception() {
    return reception;
  }

  public void setReception(Reception reception) {
    this.reception = reception;
  }

  public PvzGet200ResponseInnerReceptionsInner products(List<@Valid Product> products) {
    this.products = products;
    return this;
  }

  public PvzGet200ResponseInnerReceptionsInner addProductsItem(Product productsItem) {
    if (this.products == null) {
      this.products = new ArrayList<>();
    }
    this.products.add(productsItem);
    return this;
  }

  /**
   * Get products
   * @return products
  */
  @Valid 
  @Schema(name = "products", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("products")
  public List<@Valid Product> getProducts() {
    return products;
  }

  public void setProducts(List<@Valid Product> products) {
    this.products = products;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PvzGet200ResponseInnerReceptionsInner pvzGet200ResponseInnerReceptionsInner = (PvzGet200ResponseInnerReceptionsInner) o;
    return Objects.equals(this.reception, pvzGet200ResponseInnerReceptionsInner.reception) &&
        Objects.equals(this.products, pvzGet200ResponseInnerReceptionsInner.products);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reception, products);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PvzGet200ResponseInnerReceptionsInner {\n");
    sb.append("    reception: ").append(toIndentedString(reception)).append("\n");
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
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

