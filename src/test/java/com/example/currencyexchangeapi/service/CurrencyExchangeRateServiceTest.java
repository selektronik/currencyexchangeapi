package com.example.currencyexchangeapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;


import com.example.currencyexchangeapi.dto.request.CurrencyExchangeRateRequest;
import com.example.currencyexchangeapi.webserviceclient.CurrencyExchangeRateWebServiceClient;
import com.example.currencyexchangeapi.webserviceclient.response.ExchangeRateWebServiceClientResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Serkan Akagunduz
 * @Date 3/2/2022 12:07 AM
 * @Version 1.0
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CurrencyExchangeRateServiceTest {

    @Autowired
    CurrencyExchangeRateWebServiceClient exchangeRateWebServiceClient;

    @Value("${exchangeRate.webService.client.api.key}")
    private String	apiKey;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void retrieveExchangeRate() {
        CurrencyExchangeRateRequest request = new CurrencyExchangeRateRequest("USD","USD");
        ExchangeRateWebServiceClientResponse response = exchangeRateWebServiceClient.retrieveLatestExchangeRate(apiKey,request.getSourceCurrency(),request.getTargetCurrency());
        assertEquals(response.getRates().get("EUR"), null);
        assertEquals(response.getRates().get("USD"), 1);
    }


}