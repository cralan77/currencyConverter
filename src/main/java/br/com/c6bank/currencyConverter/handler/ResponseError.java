package br.com.c6bank.currencyConverter.handler;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class ResponseError {
    private LocalDateTime dateTime = LocalDateTime.now(ZoneOffset.UTC);
    private String status = "error";
    private int statusCode=400;
    private String error;

    public LocalDateTime getDateTime() {
        return dateTime;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
