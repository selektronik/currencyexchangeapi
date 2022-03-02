package com.example.currencyexchangeapi.dao;

import com.example.currencyexchangeapi.entity.CurrencyConversion;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Serkan Akagunduz
 * @Date 2/27/2022 11:36 PM
 * @Version 1.0
 */
@Repository
public interface CurrencyConversionRepository extends PagingAndSortingRepository<CurrencyConversion,Long>,
    JpaSpecificationExecutor<CurrencyConversion> {
}
