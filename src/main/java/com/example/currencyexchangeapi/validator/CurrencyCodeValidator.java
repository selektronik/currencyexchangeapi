package com.example.currencyexchangeapi.validator;

import com.example.currencyexchangeapi.dto.enums.AvailableCurrencySymbolsEnum;
import java.util.Arrays;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author Serkan Akagunduz
 * @Date 2/28/2022 7:50 PM
 * @Version 1.0
 */
 class CurrencyCodeValidator implements ConstraintValidator<ValidCurrencyCode, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return Arrays.stream(AvailableCurrencySymbolsEnum.values()).anyMatch(currencySymbol-> currencySymbol.name().equalsIgnoreCase(value));
    }
}
