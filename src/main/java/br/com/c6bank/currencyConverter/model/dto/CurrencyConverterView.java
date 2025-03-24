package br.com.c6bank.currencyConverter.model.dto;

import br.com.c6bank.currencyConverter.model.entity.Transaction;
import br.com.c6bank.currencyConverter.model.entity.TransactionConverter;

import java.time.LocalDateTime;

public class CurrencyConverterView {
    private Long idTransaction;
    private Long user_Id;
    private String currencyOrigin;
    private Double amountOrigin;
    private String currencyDestination;
    private Double amountDestination;
    private Double rateConversion;
    private LocalDateTime dateTime;


    public Long getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Long idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Long getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Long user_Id) {
        this.user_Id = user_Id;
    }

    public String getCurrencyOrigin() {
        return currencyOrigin;
    }

    public void setCurrencyOrigin(String currencyOrigin) {
        this.currencyOrigin = currencyOrigin;
    }

    public Double getAmountOrigin() {
        return amountOrigin;
    }

    public void setAmountOrigin(Double amountOrigin) {
        this.amountOrigin = amountOrigin;
    }

    public String getCurrencyDestination() {
        return currencyDestination;
    }

    public void setCurrencyDestination(String currencyDestination) {
        this.currencyDestination = currencyDestination;
    }

    public Double getAmountDestination() {
        return amountDestination;
    }

    public void setAmountDestination(Double amountDestination) {
        this.amountDestination = amountDestination;
    }

    public Double getRateConversion() {
        return rateConversion;
    }

    public void setRateConversion(Double rateConversion) {
        this.rateConversion = rateConversion;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public CurrencyConverterView(Transaction transaction, TransactionConverter transactionConverter){
        this.idTransaction = transaction.getId();
        this.user_Id = transaction.getUser_Id();
        this.currencyOrigin = transaction.getCurrencyOrigin();
        this.amountOrigin = transaction.getAmountOrigin();
        this.currencyDestination = transaction.getCurrencyDestination();
        this.amountDestination = transactionConverter.getAmountDestination();
        this.rateConversion = transaction.getRateConversion();
        this.dateTime = transaction.getDateTime();
    };

}
