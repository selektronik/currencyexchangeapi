package com.example.currencyexchangeapi.dto.utilities.result;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Serkan Akagunduz
 * @Date 2/27/2022
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class  DataResult<T> extends Result {

    private T data;
    public DataResult(T data, boolean success, String message) {
        super(success, message);
        this.data = data;
    }

    public DataResult(T data, boolean success) {
        super(success);
        this.data = data;
    }
}
