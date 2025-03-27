package br.com.c6bank.currencyConverter.model.entity;


import br.com.c6bank.currencyConverter.controller.CurrencyConverterRestController;
import br.com.c6bank.currencyConverter.model.repository.AmountConverterRepository;
import br.com.c6bank.currencyConverter.model.repository.ExchangeRatesRepository;
import br.com.c6bank.currencyConverter.model.repository.TransactionRepository;
import br.com.c6bank.currencyConverter.service.AmountConverterService;
import br.com.c6bank.currencyConverter.service.TransactionService;
import br.com.c6bank.currencyConverter.service.impl.AmountConverterServiceImpl;
import br.com.c6bank.currencyConverter.service.impl.TransactionServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import java.util.HashMap;
import java.util.Map;


public class TransactionTest {


    private Transaction transaction = new Transaction();
    private ExchangeRates exchangeRates = new ExchangeRates();
    private AmountConverter fixedAmount = new AmountConverter();


    @BeforeEach
    void createTransaction(){
        transaction.setUser_Id(4L);
        transaction.setCurrencyOrigin("BRL");
        transaction.setCurrencyDestination("PLN");
        transaction.setAmountOrigin(100.00);
        transaction.setRateConversion(0.6769);

        fixedAmount.setAmountDestination(67.69);

        transaction.setAmountConverter(fixedAmount);


    }


    @BeforeEach
    void createExchangeRates(){
        Map<String, Double> rates = new HashMap<>();
        rates.put("BRL", 6.180669);
        rates.put("PLN", 4.184223);

        exchangeRates.setRates(rates);

    }

    @Test
    void validateTransaction(){
        Assertions.assertDoesNotThrow(() -> transaction.validateTransaction());
    }
    @Test
    void converterAmount(){
        AmountConverterService amountConverterService = new AmountConverterServiceImpl();
        Assertions.assertEquals(67.69 , amountConverterService.converterAmount(transaction).getAmountDestination());
    }

    @Test
    void calculateRate(){
        TransactionService transactionService = new TransactionServiceImpl();
        Assertions.assertEquals(0.6769, transactionService.calculateRate(exchangeRates, transaction),  0.01d);
    }


}
