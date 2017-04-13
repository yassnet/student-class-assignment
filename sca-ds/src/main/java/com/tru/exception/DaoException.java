package com.tru.exception;

/**
 * Created by yassnet on 4/13/17.
 */
public class DaoException extends Exception {

    private String message;
    private String causeMessage;

    public DaoException(String message, String causeMessage) {
        this.message = message;
        this.causeMessage = causeMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCauseMessage() {
        return causeMessage;
    }

    public void setCauseMessage(String causeMessage) {
        this.causeMessage = causeMessage;
    }
}
