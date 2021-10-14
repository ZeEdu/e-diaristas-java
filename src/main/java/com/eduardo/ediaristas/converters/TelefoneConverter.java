package com.eduardo.ediaristas.converters;

import javax.persistence.AttributeConverter;

public class TelefoneConverter implements AttributeConverter<String, String> {

	@Override
	public String convertToDatabaseColumn(String attribute) {
		return attribute.replaceAll("[() -)]", "");
	}

	@Override
	public String convertToEntityAttribute(String dbData) {
		return dbData;
	}

}
