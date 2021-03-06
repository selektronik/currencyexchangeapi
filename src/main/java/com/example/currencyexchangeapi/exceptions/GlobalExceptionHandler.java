package com.example.currencyexchangeapi.exceptions;

import com.example.currencyexchangeapi.dto.utilities.result.ErrorDataResult;
import java.net.BindException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.StreamSupport;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.validation.BindValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

/**
 * @Author Serkan Akagunduz
 * @Date 2/28/2022 9:20 PM
 * @Version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({ Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDataResult handleException(Exception e) {
        logger.error(getErrorOpenningTag(ErrorCode.GENERIC_ERROR.getCode()), e);
        return new ErrorDataResult(ErrorCode.GENERIC_ERROR.getMsg(), ErrorCode.GENERIC_ERROR.getCode());
    }

    @ExceptionHandler({ NoSuchElementException.class })
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorDataResult handleNoCurrencyConversionException(NoSuchElementException e) {
        logger.error(getErrorOpenningTag(ErrorCode.NO_RECORDS_FOUND.getCode()), e);
        return new ErrorDataResult(e.getMessage(), ErrorCode.NO_RECORDS_FOUND.getCode());
    }

    @ExceptionHandler({ HttpServerErrorException.class, HttpServerErrorException.ServiceUnavailable.class })
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    public ErrorDataResult handleServiceUnavailableException(Exception e) {
        logger.error(getErrorOpenningTag(ErrorCode.SERVICE_UNAVAILABLE.getCode()), e);
        return new ErrorDataResult(ErrorCode.SERVICE_UNAVAILABLE.getMsg(), ErrorCode.SERVICE_UNAVAILABLE.getCode());
    }

    @ExceptionHandler({ MissingServletRequestParameterException.class,
        UnsatisfiedServletRequestParameterException.class, BindException.class,
        ConstraintViolationException.class })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorDataResult handleInvalidParameterExceptions(ConstraintViolationException ex) {
        Map<String, String> errors = getConstraintViolationMultiMessage(ex);
        logger.error(getErrorOpenningTag(ErrorCode.INVALID_PARAMETERS.getCode()), ex);
        return new ErrorDataResult(errors, ErrorCode.INVALID_PARAMETERS.getCode());
    }

    private Map<String, String> getConstraintViolationMultiMessage(ConstraintViolationException ex) {
        Map<String,String> errors = new HashMap<>();
        ex.getConstraintViolations().forEach((error)->{
            String fieldName = StreamSupport.stream(
                error.getPropertyPath().spliterator(), false).
                reduce((first, second) -> second).get().toString();
            String message =  error.getMessage();
            errors.put(fieldName,message);
        });
        return errors;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, BindValidationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult onMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        logger.error(getErrorOpenningTag(ErrorCode.INVALID_PARAMETERS.getCode()), ex);
        return new ErrorDataResult(getMultiValueMessageMap(ex), ErrorCode.INVALID_PARAMETERS.getCode());
    }

    private Map<String, String> getMultiValueMessageMap(MethodArgumentNotValidException ex) {
        Map<String,String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName,message);
        });
        return errors;
    }

    @ExceptionHandler({ CurrencyExchangeRunTimeException.class })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorDataResult handleCurrencyExchangeRunTimeException(CurrencyExchangeRunTimeException e) {
        logger.error(getErrorOpenningTag(ErrorCode.NO_RECORDS_FOUND.getCode()), e);
        return new ErrorDataResult(e.getMessage(), ErrorCode.INVALID_PARAMETERS.getCode());
    }


    private String getErrorOpenningTag(int errorCode) {
        return "<ERROR_CODE_" + errorCode + ">";
    }

}
