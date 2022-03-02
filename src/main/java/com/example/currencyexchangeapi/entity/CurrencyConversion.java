package com.example.currencyexchangeapi.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Serkan Akagunduz
 * @Date 2/27/2022 10:36 PM
 * @Version 1.0
 */
@Entity
@Table(name= "CURRENCY_CONVERSION")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConversion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date transactionDate;
    private String sourceCurrency;
    private String targetCurrency;
    private BigDecimal sourceCurrencyAmount;
    private BigDecimal targetCurrencyAmount;

}

