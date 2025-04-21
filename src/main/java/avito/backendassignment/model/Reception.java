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
 * Reception
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-21T05:51:18.622903100+03:00[Europe/Moscow]")
public class Reception {
	
	private UUID id;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private OffsetDateTime dateTime;
	
	private UUID pvzId;
	
	private StatusEnum status;
	
	public Reception() {
		super();
	}
	
	/**
	 * Constructor with only required parameters
	 */
	public Reception(OffsetDateTime dateTime, UUID pvzId, StatusEnum status) {
		this.dateTime = dateTime;
		this.pvzId = pvzId;
		this.status = status;
	}
	
	public Reception id(UUID id) {
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
	
	public Reception dateTime(OffsetDateTime dateTime) {
		this.dateTime = dateTime;
		return this;
	}
	
	/**
	 * Get dateTime
	 *
	 * @return dateTime
	 */
	@NotNull
	@Valid
	@Schema(name = "dateTime", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("dateTime")
	public OffsetDateTime getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(OffsetDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
	public Reception pvzId(UUID pvzId) {
		this.pvzId = pvzId;
		return this;
	}
	
	/**
	 * Get pvzId
	 *
	 * @return pvzId
	 */
	@NotNull
	@Valid
	@Schema(name = "pvzId", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("pvzId")
	public UUID getPvzId() {
		return pvzId;
	}
	
	public void setPvzId(UUID pvzId) {
		this.pvzId = pvzId;
	}
	
	public Reception status(StatusEnum status) {
		this.status = status;
		return this;
	}
	
	/**
	 * Get status
	 *
	 * @return status
	 */
	@NotNull
	@Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("status")
	public StatusEnum getStatus() {
		return status;
	}
	
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Reception reception = (Reception) o;
		return Objects.equals(this.id, reception.id) &&
				Objects.equals(this.dateTime, reception.dateTime) &&
				Objects.equals(this.pvzId, reception.pvzId) &&
				Objects.equals(this.status, reception.status);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, dateTime, pvzId, status);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Reception {\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    dateTime: ").append(toIndentedString(dateTime)).append("\n");
		sb.append("    pvzId: ").append(toIndentedString(pvzId)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

