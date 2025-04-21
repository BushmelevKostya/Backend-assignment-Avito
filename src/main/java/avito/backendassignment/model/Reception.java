package avito.backendassignment.model;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.lang.Long;
import java.time.OffsetDateTime;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

/**
 * Reception
 */
@Table("receptions")
@Setter
@Getter
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-21T05:51:18.622903100+03:00[Europe/Moscow]")
public class Reception {
	
	@Id
	private Long id;
	
	@NotNull
	private OffsetDateTime dateTime;
	
	@NotNull
	private Long pvzId;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusEnum status;
	
	public Reception() {
		super();
	}
	
	public Reception(OffsetDateTime dateTime, Long pvzId, StatusEnum status) {
		this.dateTime = dateTime;
		this.pvzId = pvzId;
		this.status = status;
	}
}
