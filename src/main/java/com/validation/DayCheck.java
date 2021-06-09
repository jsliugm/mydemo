package com.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
 
/**
 * @author king
 */
@Documented
@Constraint(validatedBy = DayValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DayCheck {
 
    String message() default "请传入符合要求的Byte值";
 
    Class<?>[] groups() default { };
 
    Class<? extends Payload>[] payload() default { };
 
}