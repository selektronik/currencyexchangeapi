package com.example.currencyexchangeapi.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import com.example.currencyexchangeapi.dao.CurrencyConversionRepository;
import com.example.currencyexchangeapi.dto.request.CurrencyConversionRequest;
import com.example.currencyexchangeapi.entity.CurrencyConversion;
import com.example.currencyexchangeapi.webserviceclient.CurrencyExchangeRateWebServiceClient;
import com.example.currencyexchangeapi.webserviceclient.response.CurrencyConversionWebServiceClientResponse;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * @Author Serkan Akagunduz
 * @Date 3/2/2022 9:15 AM
 * @Version 1.0
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CurrencyConversionServiceTest {

    @Mock
    private CurrencyConversionRepository currencyConversionRepository;

    @Autowired
    CurrencyExchangeRateWebServiceClient exchangeRateWebServiceClient;

    @Value("${exchangeRate.webService.client.api.key}")
    private String	apiKey;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void convertCurrency() {
        CurrencyConversion currencyConversion =
            new CurrencyConversion(1L, new Date(), "USD", "TRY", BigDecimal.valueOf(300L), BigDecimal.valueOf(400L));
        CurrencyConversionRequest request =
            new CurrencyConversionRequest(currencyConversion.getSourceCurrencyAmount(), currencyConversion.getSourceCurrency(),
                currencyConversion.getTargetCurrency());
        CurrencyConversionWebServiceClientResponse response = exchangeRateWebServiceClient.convertCurrency(apiKey,request.getSourceCurrency(),request.getTargetCurrency(),request.getSourceCurrencyAmount());
        assertEquals(response.getQuery().getFrom(),"USD");
        assertEquals(response.getQuery().getTo(),"TRY");
        assertEquals(response.isSuccess(),true);
        when(currencyConversionRepository.save(currencyConversion)).thenReturn(currencyConversion);
        assertEquals(currencyConversionRepository.save(currencyConversion), currencyConversion);
        verify(currencyConversionRepository, times(1)).save(currencyConversion);
    }

    @Test
    void searchCurrencyConversionList() {
        int pageNumber = 0;
        int pageSize = 1;
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("id"));
        CurrencyConversion currencyConversion = new CurrencyConversion(1L,new Date(),"USD","TRY", BigDecimal.valueOf(300L),BigDecimal.valueOf(400L));
        Page<CurrencyConversion> currencyConversionPage = new PageImpl<>(Collections.singletonList(currencyConversion));
        when(currencyConversionRepository.findAll(pageable)).thenReturn(currencyConversionPage);
        Page<CurrencyConversion> currencyConversionList = currencyConversionRepository.findAll(pageable);
        assertEquals(currencyConversionList.getNumberOfElements(), 1);
    }


}