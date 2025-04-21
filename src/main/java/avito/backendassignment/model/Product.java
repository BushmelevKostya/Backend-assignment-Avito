package avito.backendassignment.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Product
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-21T05:51:18.622903100+03:00[Europe/Moscow]")
public class Product {
	
	private UUID id;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private OffsetDateTime dateTime;
	
	/**
	 * Gets or Sets type
	 */
	
	private TypeEnum type;
	
	private UUID receptionId;
	
	public Product() {
		super();
	}
	
	/**
	 * Constructor with only required parameters
	 */
	public Product(TypeEnum type, UUID receptionId) {
		this.type = type;
		this.receptionId = receptionId;
	}
	
	public Product id(UUID id) {
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
	
	public Product dateTime(OffsetDateTime dateTime) {
		this.dateTime = dateTime;
		return this;
	}
	
	/**
	 * Get dateTime
	 *
	 * @return dateTime
	 */
	@Valid
	@Schema(name = "dateTime", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("dateTime")
	public OffsetDateTime getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(OffsetDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	public Product type(TypeEnum type) {
		this.type = type;
		return this;
	}
	
	/**
	 * Get type
	 *
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
	
	public Product receptionId(UUID receptionId) {
		this.receptionId = receptionId;
		return this;
	}
	
	/**
	 * Get receptionId
	 *
	 * @return receptionId
	 */
	@NotNull
	@Valid
	@Schema(name = "receptionId", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("receptionId")
	public UUID getReceptionId() {
		return receptionId;
	}
	
	public void setReceptionId(UUID receptionId) {
		this.receptionId = receptionId;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Product product = (Product) o;
		return Objects.equals(this.id, product.id) &&
				Objects.equals(this.dateTime, product.dateTime) &&
				Objects.equals(this.type, product.type) &&
				Objects.equals(this.receptionId, product.receptionId);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, dateTime, type, receptionId);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Product {\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    receptionId: ").append(toIndentedString(receptionId)).append("\n");
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

