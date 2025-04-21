package avito.backendassignment.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * PVZ
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-21T05:51:18.622903100+03:00[Europe/Moscow]")
public class PVZ {
	
	private UUID id;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private OffsetDateTime registrationDate;
	
	/**
	 * Gets or Sets city
	 */
	public enum CityEnum {
		_1("Москва"),
		
		_2("Санкт-Петербург"),
		
		_3("Казань");
		
		private String value;
		
		CityEnum(String value) {
			this.value = value;
		}
		
		@JsonValue
		public String getValue() {
			return value;
		}
		
		@Override
		public String toString() {
			return String.valueOf(value);
		}
		
		@JsonCreator
		public static CityEnum fromValue(String value) {
			for (CityEnum b : CityEnum.values()) {
				if (b.value.equals(value)) {
					return b;
				}
			}
			throw new IllegalArgumentException("Unexpected value '" + value + "'");
		}
	}
	
	private CityEnum city;
	
	public PVZ() {
		super();
	}
	
	/**
	 * Constructor with only required parameters
	 */
	public PVZ(CityEnum city) {
		this.city = city;
	}
	
	public PVZ id(UUID id) {
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
	
	public PVZ registrationDate(OffsetDateTime registrationDate) {
		this.registrationDate = registrationDate;
		return this;
	}
	
	/**
	 * Get registrationDate
	 *
	 * @return registrationDate
	 */
	@Valid
	@Schema(name = "registrationDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
	@JsonProperty("registrationDate")
	public OffsetDateTime getRegistrationDate() {
		return registrationDate;
	}
	
	public void setRegistrationDate(OffsetDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public PVZ city(CityEnum city) {
		this.city = city;
		return this;
	}
	
	/**
	 * Get city
	 *
	 * @return city
	 */
	@NotNull
	@Schema(name = "city", requiredMode = Schema.RequiredMode.REQUIRED)
	@JsonProperty("city")
	public CityEnum getCity() {
		return city;
	}
	
	public void setCity(CityEnum city) {
		this.city = city;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PVZ PVZ = (PVZ) o;
		return Objects.equals(this.id, PVZ.id) &&
				Objects.equals(this.registrationDate, PVZ.registrationDate) &&
				Objects.equals(this.city, PVZ.city);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, registrationDate, city);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PVZ {\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    registrationDate: ").append(toIndentedString(registrationDate)).append("\n");
		sb.append("    city: ").append(toIndentedString(city)).append("\n");
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

