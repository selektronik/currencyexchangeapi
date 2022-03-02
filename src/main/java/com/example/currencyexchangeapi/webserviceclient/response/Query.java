package com.example.currencyexchangeapi.webserviceclient.response;

import java.math.BigDecimal;
import lombok.Data;

/**
 * @Author Serkan Akagunduz
 * @Date 2/27/2022 10:08 PM
 * @Version 1.0
 */
@Data
public class Query {

    private String from;
    private String to;
    private BigDecimal amount;

}
