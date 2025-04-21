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
 * Product
 */
@Table("products")
@Setter
@Getter
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-04-21T05:51:18.622903100+03:00[Europe/Moscow]")
public class Product {
	
	@Id
	private Long id;
	
	private OffsetDateTime dateTime;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TypeEnum type;
	
	@NotNull
	private Long receptionId;
	
	public Product() {
		super();
	}
	
	public Product(TypeEnum type, Long receptionId) {
		this.type = type;
		this.receptionId = receptionId;
	}
}
