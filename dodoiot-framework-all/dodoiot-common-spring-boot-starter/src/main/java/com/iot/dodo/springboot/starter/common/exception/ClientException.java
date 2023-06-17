package com.iot.dodo.springboot.starter.common.exception;

import com.iot.dodo.springboot.starter.common.errorcode.BaseErrorCode;
import com.iot.dodo.springboot.starter.common.errorcode.ErrorCode;

import java.io.Serial;

/**
 * 客户端异常
 *
 * @author lwh
 * @date 2023-06-11 21:26:49
 */
public class ClientException extends AbstractException {
    @Serial
    private static final long serialVersionUID = -8137965287849665365L;

    public ClientException(ErrorCode errorCode) {
        this(null, null, errorCode);
    }

    public ClientException(String message) {
        this(message, null, BaseErrorCode.CLIENT_ERROR);
    }

    public ClientException(String message, ErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public ClientException(String errorMessage, Throwable throwable, ErrorCode errorCode) {
        super(errorMessage, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "ClientException{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}