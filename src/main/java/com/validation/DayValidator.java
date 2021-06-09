package com.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author king
 */
public class DayValidator implements ConstraintValidator<DayCheck, Date> {
    @Override
    public void initialize(DayCheck constraintAnnotation) {
    }

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("hahaha").addConstraintViolation();
        return false;
    }

}
