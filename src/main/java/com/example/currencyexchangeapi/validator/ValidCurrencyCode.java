package com.example.currencyexchangeapi.validator;

import static com.example.currencyexchangeapi.exceptions.ErrorMessageConstants.INVALID_CURRENCY_MSG;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Author Serkan Akagunduz
 * @Date 2/28/2022 7:46 PM
 * @Version 1.0
 */

@Documented
@Constraint(validatedBy = CurrencyCodeValidator.class)
@NotNull
@Size(min = 3, max = 3)
@ReportAsSingleViolation
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCurrencyCode {

    String message() default INVALID_CURRENCY_MSG;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
