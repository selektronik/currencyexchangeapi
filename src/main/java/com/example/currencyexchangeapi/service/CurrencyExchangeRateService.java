package com.example.currencyexchangeapi.service;

import com.example.currencyexchangeapi.dto.request.CurrencyExchangeRateRequest;
import com.example.currencyexchangeapi.dto.response.CurrencyExchangeRateResponse;
import com.example.currencyexchangeapi.dto.utilities.result.DataResult;

/**
 * @Author Serkan Akagunduz
 * @Date 2/27/2022 8:14 PM
 * @Version 1.0
 */
public interface CurrencyExchangeRateService {

    DataResult<CurrencyExchangeRateResponse> retrieveExchangeRate(CurrencyExchangeRateRequest request);

}
