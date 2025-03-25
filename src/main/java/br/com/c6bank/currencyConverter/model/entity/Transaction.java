package br.com.c6bank.currencyConverter.model.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    private Long user_Id;
    private String currencyOrigin;
    private Double amountOrigin;
    private String currencyDestination;
    private Double rateConversion;
    private LocalDateTime dateTime;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="amount_id", referencedColumnName = "IDAMOUNTCONVERTER")
    private AmountConverter amountConverter;

    public AmountConverter getTransactionConverter() {
        return amountConverter;
    }

    public void setTransactionConverter(AmountConverter amountConverter) {
        this.amountConverter = amountConverter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
