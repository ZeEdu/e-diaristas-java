package com.eduardo.ediaristas.converters;

import javax.persistence.AttributeConverter;

public class CepConverter implements AttributeConverter<String, String> {

	@Override
	public String convertToDatabaseColumn(String attribute) {
		return attribute.replace("-", "");
	}

	@Override
	public String convertToEntityAttribute(String dbData) {
		return dbData;
	}

}
