package com.example.currencyexchangeapi.dto.response;

import java.io.Serializable;
import lombok.Data;

/**
 * @Author Serkan Akagunduz
 * @Date 2/27/2022
 * @Version 1.0
 */
@Data
public class CurrencyExchangeRateResponse implements Serializable {
    private static final long serialVersionUID =  6212183109818L;

    private Double exchangeRate;
}
