package com.example.currencyexchangeapi.dto.utilities.result;

/**
 * @Author Serkan Akagunduz
 * @Date 2/27/2022
 * @Version 1.0
 */
public class SuccessDataResult<T> extends DataResult<T> {

    public SuccessDataResult(T data, String message) {
        super(data, true ,message);
    }

}
