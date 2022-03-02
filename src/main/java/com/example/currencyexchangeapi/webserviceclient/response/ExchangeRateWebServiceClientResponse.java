package com.example.currencyexchangeapi.webserviceclient.response;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Serkan Akagunduz
 * @Date 2/27/2022 10:06 PM
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRateWebServiceClientResponse implements Serializable {

    private boolean success;
    private long timestamp;
    private boolean historical;
    private String base;
    private Date date;
    private LinkedHashMap<String,Double> rates = new LinkedHashMap<>();
    private LinkedHashMap<String,String> symbols = new LinkedHashMap<>();

}
