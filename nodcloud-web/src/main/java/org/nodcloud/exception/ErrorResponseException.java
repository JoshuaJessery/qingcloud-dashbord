package org.nodcloud.exception;

import org.nodcloud.qing.sdk.core.Response;

public class ErrorResponseException extends Exception {

    private int code;
    private String message;

    public ErrorResponseException(Response response) {
        this.code = response.getRetCode();
        this.message = response.getMessage();
    }

    public ErrorResponseException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
