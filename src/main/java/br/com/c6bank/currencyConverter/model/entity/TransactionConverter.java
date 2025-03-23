package br.com.c6bank.currencyConverter.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TRANSACTIONCONVERTER")
public class TransactionConverter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_transaction", nullable = false)
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
}
