package com.example.currencyexchangeapi.dto.request;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Author Serkan Akagunduz
 * @Date 2/27/2022
 * @Version 1.0
 */
@Data
public class SearchCurrencyConversionRequest {

    @ApiModelProperty( value = "Transaction ID", example = "1")
    private Long transactionId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty( value = "Transaction Date", example = "2022-01-19")
    private Date transactionDate;
}
