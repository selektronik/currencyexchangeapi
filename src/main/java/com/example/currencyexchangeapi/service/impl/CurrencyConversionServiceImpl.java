package com.example.currencyexchangeapi.service.impl;

import com.example.currencyexchangeapi.dao.CurrencyConversionRepository;
import com.example.currencyexchangeapi.dao.CurrencyConversionSpecification;
import com.example.currencyexchangeapi.dto.request.CurrencyConversionRequest;
import com.example.currencyexchangeapi.dto.request.SearchCurrencyConversionRequest;
import com.example.currencyexchangeapi.dto.response.CurrencyConversionResponse;
import com.example.currencyexchangeapi.dto.response.SearchCurrencyConversionResponse;
import com.example.currencyexchangeapi.dto.utilities.result.DataResult;
import com.example.currencyexchangeapi.dto.utilities.result.SuccessDataResult;
import com.example.currencyexchangeapi.entity.CurrencyConversion;
import com.example.currencyexchangeapi.exceptions.CurrencyExchangeRunTimeException;
import com.example.currencyexchangeapi.exceptions.ErrorMessageConstants;
import com.example.currencyexchangeapi.service.CurrencyConversionService;
import com.example.currencyexchangeapi.webserviceclient.CurrencyExchangeRateWebServiceClient;
import com.example.currencyexchangeapi.webserviceclient.response.CurrencyConversionWebServiceClientResponse;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Serkan Akagunduz
 * @Date 2/27/2022 11:31 PM
 * @Version 1.0
 */

@Service
@Transactional
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

    private final Logger logger	= LoggerFactory.getLogger(CurrencyConversionServiceImpl.class);

    private static final String SOURCE_CURRENCY_WAS_CONVERTED_TO_TARGET_CURRENCY_SUCCESSFULLY = "Source currency amount was converted to target currency amount successfully.";
    private static final String SEARCH_CURRENCY_CONVERSION_SERVICE_WAS_CALLED_SUCCESSFULLY = "Search currency conversion service was called successfully.";

    @Value("${exchangeRate.webService.client.api.key}")
    private String	exchangeRateWebServiceClientApiKey;

    @Autowired
    CurrencyExchangeRateWebServiceClient exchangeRateWebServiceClient;

    @Autowired
    CurrencyConversionRepository currencyConversionRepository;

     /**
     * Convert Source Currency Amount
     * To Target Currency
     * @param request
     * @return
     */
    @Override
    public DataResult<CurrencyConversionResponse> convertCurrency(CurrencyConversionRequest request) {
        CurrencyConversionResponse currencyConversionResponse = new CurrencyConversionResponse();
        CurrencyConversionWebServiceClientResponse currencyConversionWebServiceClientResponse =
        exchangeRateWebServiceClient.convertCurrency(exchangeRateWebServiceClientApiKey,request.getSourceCurrency(),request.getTargetCurrency(),request.getSourceCurrencyAmount());
        CurrencyConversion savedCurrencyConversion = saveCurrencyConversion(currencyConversionWebServiceClientResponse);
        currencyConversionResponse.setTransactionId(savedCurrencyConversion.getId());
        currencyConversionResponse.setTargetCurrencyAmount(savedCurrencyConversion.getTargetCurrencyAmount());
        return new SuccessDataResult<>(currencyConversionResponse, SOURCE_CURRENCY_WAS_CONVERTED_TO_TARGET_CURRENCY_SUCCESSFULLY);
    }

    private CurrencyConversion saveCurrencyConversion(CurrencyConversionWebServiceClientResponse currencyConversionWebServiceClientResponse) {
        CurrencyConversion currencyConversion = new CurrencyConversion();
        currencyConversion.setTransactionDate(new Date());
        currencyConversion.setSourceCurrency(currencyConversionWebServiceClientResponse.getQuery().getFrom());
        currencyConversion.setTargetCurrency(currencyConversionWebServiceClientResponse.getQuery().getTo());
        currencyConversion.setSourceCurrencyAmount(currencyConversionWebServiceClientResponse.getQuery().getAmount());
        currencyConversion.setTargetCurrencyAmount(currencyConversionWebServiceClientResponse.getResult());
        return currencyConversionRepository.save(currencyConversion);
    }


    /**
     * Return Currency Conversion List
     * According To Transaction Date/Transation Id
     * @param request
     * @param page
     * @param size
     * @return
     */
    @Transactional( readOnly = true )
    @Override
    public DataResult<SearchCurrencyConversionResponse> searchCurrencyConversionList(SearchCurrencyConversionRequest request, int page, int size) {
        SearchCurrencyConversionResponse searchCurrencyConversionResponse = new SearchCurrencyConversionResponse();
        validateSearchCurrencyConversionRequest(request);
        CurrencyConversionSpecification currencyConversionSpecification = new CurrencyConversionSpecification();
        currencyConversionSpecification.setSearchCurrencyConversionRequest(request);
        Pageable requestedPage =  PageRequest.of(page, size, Sort.by("id"));
        Page<CurrencyConversion> currencyConversionList = currencyConversionRepository.findAll(currencyConversionSpecification, requestedPage);
        searchCurrencyConversionResponse.setCurrencyConversionList(currencyConversionList.getContent());
        return new SuccessDataResult<>(searchCurrencyConversionResponse, SEARCH_CURRENCY_CONVERSION_SERVICE_WAS_CALLED_SUCCESSFULLY);
    }

    private void validateSearchCurrencyConversionRequest(SearchCurrencyConversionRequest request) {
        if(request.getTransactionId() == null && request.getTransactionDate() == null){
            throw new CurrencyExchangeRunTimeException(ErrorMessageConstants.SEARCH_CURRENCY_CONVERSION_VALIDATION_MSG);
        }
    }

}
