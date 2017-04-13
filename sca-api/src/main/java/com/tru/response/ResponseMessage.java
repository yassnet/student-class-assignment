package com.tru.response;

import java.io.Serializable;

/**
 * Created by yassnet on 4/13/17.
 */
public class ResponseMessage implements Serializable {

    String message;

    public ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}