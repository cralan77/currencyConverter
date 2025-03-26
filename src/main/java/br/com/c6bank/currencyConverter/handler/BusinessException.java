package br.com.c6bank.currencyConverter.handler;

public class BusinessException  extends RuntimeException{

    public BusinessException(String message){
        super(message);
    }

    public BusinessException(String message, Object ... params){
        super(String.format(message, params));
    }
}
