package com.example.clinicsystem.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        // Convert boolean to 'F' (finished) or 'P' (pending)
        return (attribute != null && attribute) ? "F" : "P";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        // Convert 'F' to true and 'P' to false
        return "F".equalsIgnoreCase(dbData);
    }
}
