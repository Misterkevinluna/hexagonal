package com.companyKLJ.hexagonal.infrastructure.repositories.util;

public class CustomException extends Exception{

    private final String errorCode;
    private CustomException(final String errorCode, final String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public static CustomException call(final String errorCode, final String message) {
        return new CustomException(errorCode, message);
    }

    public String getErrorCode() {
        return errorCode;
    }
}
