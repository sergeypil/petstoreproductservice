package com.chtrembl.petstore.product.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StatusEnumConverter implements AttributeConverter<StatusEnum, String> {

    @Override
    public String convertToDatabaseColumn(StatusEnum attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public StatusEnum convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return StatusEnum.fromValue(value);
    }
}