package com.tuc.myself.blog.exception;

/**
 * @Auther: tuc
 * @Date: 2020-03-02 14:56
 */
public class UserException extends RuntimeException {

    private static final long serialVersionUID = -8134882542484012204L;

    public UserException() {
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }

    public UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
