package com.example.casestudy5.util.customValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BirthDayValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BirthDayCustom {
    String message();
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
