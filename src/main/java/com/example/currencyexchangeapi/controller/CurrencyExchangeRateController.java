package com.example.currencyexchangeapi.controller;



import com.example.currencyexchangeapi.dto.request.CurrencyConversionRequest;
import com.example.currencyexchangeapi.dto.request.CurrencyExchangeRateRequest;
import com.example.currencyexchangeapi.dto.request.SearchCurrencyConversionRequest;
import com.example.currencyexchangeapi.dto.response.CurrencyConversionResponse;
import com.example.currencyexchangeapi.dto.response.CurrencyExchangeRateResponse;
import com.example.currencyexchangeapi.dto.response.SearchCurrencyConversionResponse;
import com.example.currencyexchangeapi.dto.utilities.result.DataResult;
import com.example.currencyexchangeapi.dto.utilities.result.SuccessDataResult;
import com.example.currencyexchangeapi.service.CurrencyConversionService;
import com.example.currencyexchangeapi.service.CurrencyExchangeRateService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Serkan Akagunduz
 * @Date 2/27/2022 8:09 PM
 * @Version 1.0
 */
@RestController
@Validated
public class CurrencyExchangeRateController {

    private static final String SOURCE_CURRENCY_WAS_CONVERTED_TO_TARGET_CURRENCY_SUCCESSFULLY = "fdsfdsfdsf";
    @Autowired
    CurrencyExchangeRateService currencyExchangeRateService;

    @Autowired
    CurrencyConversionService currencyConversionService;


    @ApiOperation( tags = "Retrieve Currency Exchange Rate", value = "Retrieve Exchange Rate", notes = "Returns Exchange Rate of Source Currency from Target Currency", response = CurrencyExchangeRateRequest.class, responseContainer = "List" )
    @ApiResponse( code = 200, message = "The transaction has been processed successfully. This code is expected to return when GET operations terminate successfully.", response = CurrencyExchangeRateResponse.class, responseContainer = "List" )
    @RequestMapping( path = "/api/v1/retrieveExchangeRate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public DataResult<CurrencyExchangeRateResponse> retrieveExchangeRate(
        @Valid CurrencyExchangeRateRequest request ) {
        return currencyExchangeRateService.retrieveExchangeRate(request);
    }


    @ApiOperation( tags = "Convert Currency", value = "Currency Conversion", notes = "Returns Convert Source Currency Amount To Target Currency Amount", response = CurrencyConversionRequest.class, responseContainer = "List" )
    @ApiResponse( code = 200, message = "The transaction has been processed successfully. This code is expected to return when POST operations terminate successfully.", response = CurrencyConversionResponse.class, responseContainer = "List" )
    @RequestMapping( path = "/api/v1/convertCurrency", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
    public DataResult<CurrencyConversionResponse> convertCurrency(@Valid @RequestBody CurrencyConversionRequest request ) {
        return currencyConversionService.convertCurrency(request);

    }


    @ApiOperation( tags = "Search Currency Conversion List", value = "Currency Conversion List", notes = "Returns Currency Conversion List According To Request Filter ", response = SearchCurrencyConversionRequest.class, responseContainer = "List" )
    @ApiResponse( code = 200, message = "The transaction has been processed successfully. This code is expected to return when GET operations terminate successfully.", response = SearchCurrencyConversionResponse.class, responseContainer = "List" )
    @RequestMapping( path = "/api/v1/findCurrencyConversionList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public DataResult<SearchCurrencyConversionResponse> findCurrencyConversionList(SearchCurrencyConversionRequest request, @RequestParam(value = "page") int page, @RequestParam(value = "size") int size) {
       return currencyConversionService.searchCurrencyConversionList(request, page, size);
    }

}
