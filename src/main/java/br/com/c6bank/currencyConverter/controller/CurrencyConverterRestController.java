package br.com.c6bank.currencyConverter.controller;

import br.com.c6bank.currencyConverter.handler.BusinessException;
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
public class CurrencyConverterRestController {

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

    //Endpoint para obter todas as transações por funcionário
    @GetMapping("/findAllByUser={user}")
    public ResponseEntity<List<Transaction>> consultExchangeRates(@PathVariable Long user){


        return ResponseEntity.ok(transactionService.findAllByUserID(user));
    }

    //Endpoint para converter valor informado
    @PostMapping("/converter")
    public ResponseEntity<Transaction> converterCurrency(@RequestBody Transaction transaction) {

        //Valida dados iniciais da transação
        transaction.validateTransaction();

        //Obtendo taxas com base nas moedas informadas
        ExchangeRates exchangeRates = exchangeRatesService.exchangeRates(transaction.getCurrencyOrigin()+","+transaction.getCurrencyDestination());

        //Determina taxa da transação
        transaction.setRateConversion(transactionService.calculateRate(exchangeRates, transaction));

        //Determina data e hora da transação
        transaction.setDateTime( LocalDateTime.now(ZoneOffset.UTC));

        //Conversão do valor
        AmountConverter amountConverter = amountConverterService.converterAmount(transaction);

        //Determina o valor final calculado na transação
        transaction.setAmountConverter(amountConverter);

        //Persistência dos dados
        try {

            exchangeRatesRepository.save(exchangeRates);

            amountConverterRepository.save(amountConverter);

            transactionRepository.save(transaction);
        }catch (Exception ex){
            throw new BusinessException("Failed to persist data");
        }

        return ResponseEntity.ok(transaction);
    }

}
