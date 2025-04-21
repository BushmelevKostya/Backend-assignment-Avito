package avito.backendassignment.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RoleEnum {
	EMPLOYEE("employee"),
	
	MODERATOR("moderator");
	
	private String value;
	
	RoleEnum(String value) {
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
	public static RoleEnum fromValue(String value) {
		for (RoleEnum b : RoleEnum.values()) {
			if (b.value.equals(value)) {
				return b;
			}
		}
		throw new IllegalArgumentException("Unexpected value '" + value + "'");
	}
}