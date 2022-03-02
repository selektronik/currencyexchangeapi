package com.example.currencyexchangeapi.exceptions;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Serkan Akagunduz
 * @Date 2/27/2022 11:33 PM
 * @Version 1.0
 */
@Data
public class CurrencyExchangeRunTimeException extends RuntimeException {

    private final Logger logger						= LoggerFactory.getLogger(CurrencyExchangeRunTimeException.class);

    private String[]		params;
    private boolean			printStackTraceLoggable	= false;

    public CurrencyExchangeRunTimeException( String message ) {
        super(message);
    }

}
