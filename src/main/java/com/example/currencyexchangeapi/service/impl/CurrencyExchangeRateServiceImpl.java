package com.example.currencyexchangeapi.service.impl;

import com.example.currencyexchangeapi.dto.request.CurrencyExchangeRateRequest;
import com.example.currencyexchangeapi.dto.response.CurrencyExchangeRateResponse;
import com.example.currencyexchangeapi.dto.utilities.result.DataResult;
import com.example.currencyexchangeapi.dto.utilities.result.SuccessDataResult;
import com.example.currencyexchangeapi.service.CurrencyExchangeRateService;
import com.example.currencyexchangeapi.webserviceclient.CurrencyExchangeRateWebServiceClient;
import com.example.currencyexchangeapi.webserviceclient.response.ExchangeRateWebServiceClientResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author Serkan Akagunduz
 * @Date 2/27/2022 10:27 PM
 * @Version 1.0
 */
@Service
public class CurrencyExchangeRateServiceImpl implements CurrencyExchangeRateService {

    private final Logger logger	= LoggerFactory.getLogger(CurrencyExchangeRateServiceImpl.class);

    private static final String  CURRENCY_EXCHANGE_RATE_WAS_RETRIEVED_SUCCESSFULLY = "Currency exchange rate was retrieved successfully.";

    @Value("${exchangeRate.webService.client.api.key}")
    private String	exchangeRateWebServiceClientApiKey;

    @Autowired
    CurrencyExchangeRateWebServiceClient exchangeRateWebServiceClient;

    @Override
    public DataResult<CurrencyExchangeRateResponse> retrieveExchangeRate(CurrencyExchangeRateRequest request) {
        CurrencyExchangeRateResponse currencyExchangeRateResponse = new CurrencyExchangeRateResponse();
        ExchangeRateWebServiceClientResponse exchangeRateWebServiceClientResponse = exchangeRateWebServiceClient.retrieveLatestExchangeRate(exchangeRateWebServiceClientApiKey,request.getSourceCurrency(),request.getTargetCurrency());
        Double exchangeRate =  exchangeRateWebServiceClientResponse.getRates().get(request.getTargetCurrency().toUpperCase());
        currencyExchangeRateResponse.setExchangeRate(exchangeRate);
        return new SuccessDataResult<>(currencyExchangeRateResponse, getSuccessfulMessage(request));
    }

    private String getSuccessfulMessage(CurrencyExchangeRateRequest request) {
        return request.getSourceCurrency().toUpperCase().concat("/").concat(request.getTargetCurrency().toUpperCase()).concat(" ").concat(CURRENCY_EXCHANGE_RATE_WAS_RETRIEVED_SUCCESSFULLY);
    }


}
