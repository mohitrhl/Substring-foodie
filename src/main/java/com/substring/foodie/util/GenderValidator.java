package com.substring.foodie.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenderValidator implements ConstraintValidator<ValidGender, String> {
    private static final Logger logger = LoggerFactory.getLogger(GenderValidator.class);


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //logic
        if (value == null || value.isEmpty()) {
            logger.warn("Invalid Gender String");
            return false;
        }

        return value.equalsIgnoreCase("male") || value.equalsIgnoreCase("female");
    }
}