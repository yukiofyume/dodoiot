package com.iot.dodo.springboot.starter.common.exception;

import com.iot.dodo.springboot.starter.common.errorcode.ErrorCode;

import java.io.Serial;

/**
 * RPC 异常
 *
 * @author lwh
 * @date 2023-06-11 21:30:32
 */
public class RemoteException extends AbstractException {

    @Serial
    private static final long serialVersionUID = -1776350900988663064L;

    public RemoteException(String message, ErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public RemoteException(String errorMessage, Throwable throwable, ErrorCode errorCode) {
        super(errorMessage, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "RemoteException{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}