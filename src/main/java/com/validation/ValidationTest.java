package com.validation;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ValidationTest {
    @Test
    public void test() {

        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<Object>> validate = validator.validate(new Date(-1, 2, 31));
        validate.forEach(it -> {
            System.out.println(it.getMessage());
        });
    }
}
