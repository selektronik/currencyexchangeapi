package com.example.currencyexchangeapi.dto.request;

import com.example.currencyexchangeapi.validator.ValidCurrencyCode;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Serkan Akagunduz
 * @Date 2/27/2022
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchangeRateRequest implements Serializable {

    @ValidCurrencyCode
    @NotBlank
    @ApiModelProperty( value = "Source Currency Symbol", example = "USD")
    private String sourceCurrency;

    @ValidCurrencyCode
    @NotBlank
    @ApiModelProperty( value = "Target Currency Symbol", example = "EUR")
    private String targetCurrency;
}
