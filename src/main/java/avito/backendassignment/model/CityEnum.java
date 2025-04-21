package avito.backendassignment.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

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