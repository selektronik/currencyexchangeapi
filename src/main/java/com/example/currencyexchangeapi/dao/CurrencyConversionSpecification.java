package com.example.currencyexchangeapi.dao;

import com.example.currencyexchangeapi.dto.request.SearchCurrencyConversionRequest;
import com.example.currencyexchangeapi.entity.CurrencyConversion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.h2.result.SortOrder;
import org.springframework.data.jpa.domain.Specification;

/**
 * @Author Serkan Akagunduz
 * @Date 2/27/2022 11:34 PM
 * @Version 1.0
 */
public class CurrencyConversionSpecification implements Specification<CurrencyConversion> {

    private SearchCurrencyConversionRequest searchCurrencyConversionRequest;

    String    sortField;
    SortOrder sortOrder;

    @Override
    public Predicate toPredicate(Root<CurrencyConversion> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = collectPredicates(root, criteriaBuilder);
        Order order = criteriaBuilder.desc(root.<String>get("id"));
        query.orderBy(order);
        query.distinct(true);

        return criteriaBuilder.and(predicates.toArray(new Predicate[ predicates.size() ]));
    }

    private List<Predicate> collectPredicates(Root<CurrencyConversion> root, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (searchCurrencyConversionRequest.getTransactionId() != null) {
            predicates.add(criteriaBuilder.equal(root.get("id"), searchCurrencyConversionRequest.getTransactionId()));
        }
        if (searchCurrencyConversionRequest.getTransactionDate() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("transactionDate"), searchCurrencyConversionRequest.getTransactionDate()));
        }

        return predicates;
    }

    public SearchCurrencyConversionRequest getSearchCurrencyConversionRequest() {
        return searchCurrencyConversionRequest;
    }

    public void setSearchCurrencyConversionRequest(SearchCurrencyConversionRequest searchCurrencyConversionRequest) {
        this.searchCurrencyConversionRequest = searchCurrencyConversionRequest;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public SortOrder getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }

}
