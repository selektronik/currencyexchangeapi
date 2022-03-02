package com.example.currencyexchangeapi.exceptions;

import static com.example.currencyexchangeapi.exceptions.ErrorMessageConstants.GENERIC_ERROR_MSG;
import static com.example.currencyexchangeapi.exceptions.ErrorMessageConstants.INVALID_PARAMETERS_MSG;
import static com.example.currencyexchangeapi.exceptions.ErrorMessageConstants.NO_RECORD_FOUND_MSG;
import static com.example.currencyexchangeapi.exceptions.ErrorMessageConstants.SEARCH_CURRENCY_CONVERSION_VALIDATION_MSG;
import static com.example.currencyexchangeapi.exceptions.ErrorMessageConstants.SERVICE_UNAVAILABLE_MSG;

/**
 * @Author Serkan Akagunduz
 * @Date 2/28/2022 9:24 PM
 * @Version 1.0
 */
public enum ErrorCode {
    SERVICE_UNAVAILABLE(101, SERVICE_UNAVAILABLE_MSG), INVALID_PARAMETERS(102, INVALID_PARAMETERS_MSG),
    GENERIC_ERROR(103, GENERIC_ERROR_MSG), NO_RECORDS_FOUND(104, NO_RECORD_FOUND_MSG),
    SEARCH_CURRENCY_CONVERSION_ERROR(105, SEARCH_CURRENCY_CONVERSION_VALIDATION_MSG);

    private final int code;
    private final String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
