package com.exxeta.musicstore.converter;

import com.exxeta.musicstore.model.Rating;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.stereotype.Component;

@Component
@Converter
public class RatingAttributeConverter implements AttributeConverter<Rating, Integer> {
 
    @Override
    public Integer convertToDatabaseColumn(Rating attribute) {
        if (attribute == null)
            return null;

        return switch (attribute) {
            case ONE -> 1;
            case TWO -> 2;
            case THREE -> 3;
            case FOUR -> 4;
            case FIVE -> 5;
        };
    }
 
    @Override
    public Rating convertToEntityAttribute(Integer dbData) {
        if (dbData == null)
            return null;

        return switch (dbData) {
            case 1 -> Rating.ONE;
            case 2 -> Rating.TWO;
            case 3 -> Rating.THREE;
            case 4 -> Rating.FOUR;
            case 5 -> Rating.FIVE;
            default -> throw new IllegalArgumentException(dbData + " not supported.");
        };
    }
 
}