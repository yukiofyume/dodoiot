package com.iot.dodo.springboot.starter.common.exception;

import com.iot.dodo.springboot.starter.common.errorcode.BaseErrorCode;
import com.iot.dodo.springboot.starter.common.errorcode.ErrorCode;

import java.io.Serial;

/**
 * @author lwh
 * @date 2023-06-11 21:31:51
 */
public class ServiceException extends AbstractException {


    @Serial
    private static final long serialVersionUID = -1981117510558643722L;

    public ServiceException(String message) {
        this(message, null, BaseErrorCode.SERVICE_ERROR);
    }

    public ServiceException(ErrorCode errorCode) {
        this(null, errorCode);
    }

    public ServiceException(String message, ErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public ServiceException(String errorMessage, Throwable throwable, ErrorCode errorCode) {
        super(errorMessage, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "ServiceException{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}