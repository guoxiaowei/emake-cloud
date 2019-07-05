package com.emake.gateway.exception;

/**
 * 403 授权拒绝
 */
public class EmakeDeniedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EmakeDeniedException() {
    }

    public EmakeDeniedException(String message) {
        super(message);
    }

    public EmakeDeniedException(Throwable cause) {
        super(cause);
    }

    public EmakeDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmakeDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
