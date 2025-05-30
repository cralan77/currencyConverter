package br.com.c6bank.currencyConverter.model.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
public class AmountConverter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDAMOUNTCONVERTER")
    private Long idAmountConverter;
    private Double amountDestination;


    @OneToOne(mappedBy = "amountConverter")
    private Transaction transaction;

    public Long getID() {
        return idAmountConverter;
    }


    public Double getAmountDestination() {
        return amountDestination;
    }

    public void setAmountDestination(Double amountDestination) {
        this.amountDestination = amountDestination;
    }
}
