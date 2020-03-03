package com.tuc.myself.blog.exception;

/**
 * @Auther: tuc
 * @Date: 2020-03-03 14:15
 */
public class ControllerException extends RuntimeException {

    private static final long serialVersionUID = -1572321149399714502L;

    public ControllerException() {
    }

    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ControllerException(Throwable cause) {
        super(cause);
    }

    public ControllerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
