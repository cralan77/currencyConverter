package br.com.c6bank.currencyConverter.controller;

import br.com.c6bank.currencyConverter.model.entity.ExchangeRates;
import br.com.c6bank.currencyConverter.model.entity.Transaction;
import br.com.c6bank.currencyConverter.model.entity.AmountConverter;
import br.com.c6bank.currencyConverter.model.repository.ExchangeRatesRepository;
import br.com.c6bank.currencyConverter.model.repository.AmountConverterRepository;
import br.com.c6bank.currencyConverter.model.repository.TransactionRepository;
import br.com.c6bank.currencyConverter.service.ExchangeRatesService;
import br.com.c6bank.currencyConverter.service.AmountConverterService;
import br.com.c6bank.currencyConverter.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@RestController
@RequestMapping("api")
public class TransactionConverterRestController {

    @Autowired
    private AmountConverterService amountConverterService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ExchangeRatesService exchangeRatesService;

    @Autowired
    private ExchangeRatesRepository exchangeRatesRepository;

    @Autowired
    private AmountConverterRepository amountConverterRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/findAllByUser={user}")
    public ResponseEntity<List<Transaction>> consultExchangeRates(@PathVariable Long user){
        return ResponseEntity.ok(transactionRepository.findAllByUserID(user));
    }

    @PostMapping("/converter")
    public ResponseEntity<Transaction> converterCurrency(@RequestBody Transaction transaction) {

        ExchangeRates exchangeRates = exchangeRatesService.exchangeRates(transaction.getCurrencyOrigin()+","+transaction.getCurrencyDestination());

        transaction.setRateConversion(transactionService.calculateRate(exchangeRates, transaction));

        transaction.setDateTime( LocalDateTime.now(ZoneOffset.UTC));

        AmountConverter amountConverter = amountConverterService.converterTransaction(transaction);

        transaction.setTransactionConverter(amountConverter);



        exchangeRatesRepository.save(exchangeRates);
        amountConverterRepository.save(amountConverter);
        transactionRepository.save(transaction);

        return ResponseEntity.ok(transaction);
    }

}
