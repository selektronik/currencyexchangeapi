package com.example.currencyexchangeapi.dto.response;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Serkan Akagunduz
 * @Date 2/27/2022
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConversionResponse {

    private BigDecimal targetCurrencyAmount;
    private Long transactionId;
}
