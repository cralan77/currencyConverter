package br.com.c6bank.currencyConverter.controller;

import br.com.c6bank.currencyConverter.model.dto.CurrencyConverterView;
import br.com.c6bank.currencyConverter.model.entity.ExchangeRates;
import br.com.c6bank.currencyConverter.model.entity.Transaction;
import br.com.c6bank.currencyConverter.model.entity.TransactionConverter;
import br.com.c6bank.currencyConverter.model.repository.ExchangeRatesRepository;
import br.com.c6bank.currencyConverter.model.repository.TransactionConverterRepository;
import br.com.c6bank.currencyConverter.model.repository.TransactionRepository;
import br.com.c6bank.currencyConverter.service.ExchangeRatesService;
import br.com.c6bank.currencyConverter.service.TransactionConverterService;
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
    private TransactionConverterService transactionConverterService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ExchangeRatesService exchangeRatesService;

    @Autowired
    private ExchangeRatesRepository exchangeRatesRepository;

    @Autowired
    private TransactionConverterRepository transactionConverterRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping("/findAllByUser={user}")
    public ResponseEntity<List<Transaction>> consultExchangeRates(@PathVariable Long user){
        return ResponseEntity.ok(transactionConverterRepository.findAllByUserID(user));
    }

    @PostMapping("/converter")
    public ResponseEntity<CurrencyConverterView> converterCurrency(@RequestBody Transaction transaction) {

        ExchangeRates exchangeRates = exchangeRatesService.exchangeRates(transaction.getCurrencyOrigin()+","+transaction.getCurrencyDestination());

        transaction= transactionService.calculateRate(exchangeRates, transaction);

        transaction.setDateTime( LocalDateTime.now(ZoneOffset.UTC));

        TransactionConverter transactionConverter = transactionConverterService.converterTransaction(transaction);

        transaction.setTransactionConverter(transactionConverter);



        exchangeRatesRepository.save(exchangeRates);
        transactionConverterRepository.save(transactionConverter);
        transactionRepository.save(transaction);

        CurrencyConverterView currencyConverterView = new CurrencyConverterView(transaction, transactionConverter);
        return ResponseEntity.ok(currencyConverterView);
    }

}
