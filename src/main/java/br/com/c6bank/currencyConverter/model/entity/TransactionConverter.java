package br.com.c6bank.currencyConverter.model.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
public class TransactionConverter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDTRANSACTIONCONVERTER")
    private Long idTransactionConverter;
    private Double amountDestination;


    @OneToOne(mappedBy = "transactionConverter")
    private Transaction transaction;

    public Long getID() {
        return idTransactionConverter;
    }


    public Double getAmountDestination() {
        return amountDestination;
    }

    public void setAmountDestination(Double amountDestination) {
        this.amountDestination = amountDestination;
    }
}
