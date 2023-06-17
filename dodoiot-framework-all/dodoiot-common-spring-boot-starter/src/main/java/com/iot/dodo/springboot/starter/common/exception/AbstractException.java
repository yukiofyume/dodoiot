package com.iot.dodo.springboot.starter.common.exception;

import com.google.common.base.Strings;
import com.iot.dodo.springboot.starter.common.errorcode.ErrorCode;

import java.io.Serial;
import java.util.Optional;

/**
 * @author lwh
 * @date 2023-06-11 21:20:13
 */
public abstract class AbstractException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -8546616547774475713L;

    public final String errorCode;

    public final String errorMessage;

    public AbstractException(String errorMessage, Throwable throwable, ErrorCode errorCode) {
        super(errorMessage, throwable);
        this.errorCode = errorCode.code();
        this.errorMessage = Optional.ofNullable(Strings.emptyToNull(errorMessage)).orElse(errorCode.message());
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}