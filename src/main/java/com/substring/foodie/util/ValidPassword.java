package com.substring.foodie.util;

import jakarta.validation.Constraint;

@Constraint(validatedBy = GenderValidator.class)
public @interface ValidPassword {
}