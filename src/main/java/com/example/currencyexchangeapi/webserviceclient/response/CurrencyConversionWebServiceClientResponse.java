package com.example.currencyexchangeapi.webserviceclient.response;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @Author Serkan Akagunduz
 * @Date 2/27/2022 10:07 PM
 * @Version 1.0
 */
@Data
public class CurrencyConversionWebServiceClientResponse {

    private boolean success;
    private Query  query;
    private Info info;
    private Date date;
    private BigDecimal result;

}
