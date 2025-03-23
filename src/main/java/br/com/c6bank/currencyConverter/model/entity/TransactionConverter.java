package br.com.c6bank.currencyConverter.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TRANSACTIONCONVERTER")
public class TransactionConverter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Double amountDestination;

    @OneToOne(mappedBy = "transactionConverter")
    private Transaction transaction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmountDestination() {
        return amountDestination;
    }

    public void setAmountDestination(Double amountDestination) {
        this.amountDestination = amountDestination;
    }
}
