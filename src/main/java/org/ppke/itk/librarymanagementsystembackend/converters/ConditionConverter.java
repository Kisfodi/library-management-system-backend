package org.ppke.itk.librarymanagementsystembackend.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.ppke.itk.librarymanagementsystembackend.domain.Condition;

@Converter(autoApply = true)
public class ConditionConverter implements AttributeConverter<Condition, String> {

    @Override
    public String convertToDatabaseColumn(Condition condition) {

        if (condition == null) {
            return null;
        }

        return condition.getCondition();
    }

    @Override
    public Condition convertToEntityAttribute(String condtion) {

        if (condtion == null) {
            return null;
        }

        return Condition.of(condtion);

    }
}
