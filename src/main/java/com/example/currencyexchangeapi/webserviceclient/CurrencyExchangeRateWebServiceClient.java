package com.example.currencyexchangeapi.webserviceclient;

import com.example.currencyexchangeapi.webserviceclient.response.CurrencyConversionWebServiceClientResponse;
import com.example.currencyexchangeapi.webserviceclient.response.ExchangeRateWebServiceClientResponse;
import java.math.BigDecimal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Serkan Akagunduz
 * @Date 2/27/2022 9:38 PM
 * @Version 1.0
 */
@FeignClient(value = "currencyExchange" , url ="${exchangeRate.webService.client.endPoint}")
public interface CurrencyExchangeRateWebServiceClient {

    @GetMapping("latest?access_key={apiKey}&base={sourceCurrency}&symbols={targetCurrency}")
    ExchangeRateWebServiceClientResponse retrieveLatestExchangeRate(@PathVariable(value = "apiKey") String apiKey,@PathVariable(value = "sourceCurrency") String sourceCurrency,
                                                                    @PathVariable(value = "targetCurrency") String targetCurrency);


    @GetMapping("convert?access_key={apiKey}&from={sourceCurrency}&to={targetCurrency}&amount={sourceCurrencyAmount}")
    CurrencyConversionWebServiceClientResponse convertCurrency(@PathVariable(value = "apiKey") String apiKey, @PathVariable(value = "sourceCurrency") String sourceCurrency,
                                                               @PathVariable(value = "targetCurrency") String targetCurrency,@PathVariable(value= "sourceCurrencyAmount")
                                                                   BigDecimal sourceCurrencyAmount);

}
