package com.example.currencyexchangeapi.dto.response;

import com.example.currencyexchangeapi.entity.CurrencyConversion;
import java.util.List;
import lombok.Data;

/**
 * @Author Serkan Akagunduz
 * @Date 2/27/2022
 * @Version 1.0
 */
@Data
public class SearchCurrencyConversionResponse {

    private List<CurrencyConversion> currencyConversionList;

}
