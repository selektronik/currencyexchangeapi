package com.example.currencyexchangeapi.exceptions;

/**
 * @Author Serkan Akagunduz
 * @Date 2/28/2022 7:49 PM
 * @Version 1.0
 */
public final class ErrorMessageConstants {
    public final static String INVALID_PARAMETERS_MSG = "Invalid parameters entered, please check your query parameters";
    public final static String SERVICE_UNAVAILABLE_MSG = "Free exchange rate provider is unavailable";
    public final static String GENERIC_ERROR_MSG = "An error occured.";
    public final static String NO_RECORD_FOUND_MSG = "No record found";
    public final static String INVALID_CURRENCY_MSG = "Invalid currency code";
    public static final String SEARCH_CURRENCY_CONVERSION_VALIDATION_MSG = "At least one of the transaction id and transaction date information must be entered.";

    private ErrorMessageConstants() {

    }

}
