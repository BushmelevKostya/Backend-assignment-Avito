package avito.backendassignment.model;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.OffsetDateTime;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

/**
 * PVZ
 */
@Table("pvz")
@Setter
@Getter
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-21T05:51:18.622903100+03:00[Europe/Moscow]")
public class PVZ {
	
	@Id
	private Long id;
	
	private OffsetDateTime registrationDate;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private CityEnum city;
	
	public PVZ() {
		super();
	}
	
	public PVZ(CityEnum city) {
		this.city = city;
	}
}
