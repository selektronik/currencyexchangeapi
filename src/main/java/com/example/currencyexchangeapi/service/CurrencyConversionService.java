package com.example.currencyexchangeapi.service;

import com.example.currencyexchangeapi.dto.request.CurrencyConversionRequest;
import com.example.currencyexchangeapi.dto.request.SearchCurrencyConversionRequest;
import com.example.currencyexchangeapi.dto.response.CurrencyConversionResponse;
import com.example.currencyexchangeapi.dto.response.SearchCurrencyConversionResponse;
import com.example.currencyexchangeapi.dto.utilities.result.DataResult;

/**
 * @Author Serkan Akagunduz
 * @Date 2/27/2022 8:14 PM
 * @Version 1.0
 */
public interface CurrencyConversionService {

    DataResult<CurrencyConversionResponse> convertCurrency(CurrencyConversionRequest request);

    DataResult<SearchCurrencyConversionResponse> searchCurrencyConversionList(SearchCurrencyConversionRequest request, int page, int size);
}
