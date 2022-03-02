package com.example.currencyexchangeapi.dto.utilities.result;

import java.util.Map;
import lombok.Data;

/**
 * @Author Serkan Akagunduz
 * @Date 2/27/2022
 * @Version 1.0
 */
@Data
public class ErrorDataResult<T> extends DataResult<T> {
    private int messageCode;
    private Map<String, String> multiValueMessageMap;

public ErrorDataResult(String message, int messageCode) {
    super(null,false,message);
    this.messageCode = messageCode;
}

public ErrorDataResult(Map<String, String> multiValueMap,int messageCode) {
    super(null, false);
    this.multiValueMessageMap = multiValueMap;
    this.messageCode = messageCode;
}

}
