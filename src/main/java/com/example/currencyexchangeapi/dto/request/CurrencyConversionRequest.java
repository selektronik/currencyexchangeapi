package com.example.currencyexchangeapi.dto.request;

import com.example.currencyexchangeapi.validator.ValidCurrencyCode;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author Serkan Akagunduz
 * @Date 2/27/2022
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class CurrencyConversionRequest {

    @NotNull
    @ApiModelProperty( value = "Source Currency Amount", example = "300")
    private BigDecimal sourceCurrencyAmount;

    @ValidCurrencyCode
    @NotBlank
    @ApiModelProperty( value = "Source Currency Symbol", example = "USD")
    private String sourceCurrency;

    @ValidCurrencyCode
    @NotBlank
    @ApiModelProperty( value = "Target Currency Symbol", example = "TRY")
    private String targetCurrency;
}
