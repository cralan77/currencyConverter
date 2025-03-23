package br.com.c6bank.currencyConverter.controller;

import br.com.c6bank.currencyConverter.model.entity.ExchangeRates;
import br.com.c6bank.currencyConverter.service.ExchangeRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("exchange")
public class ExchangeRatesRestController {

    @Autowired
    private ExchangeRatesService exchangeRatesService;
    @GetMapping("/{symbols}")
    public ResponseEntity<ExchangeRates> consultExchangeRates(@PathVariable String symbols){
        return ResponseEntity.ok(exchangeRatesService.exchangeRates(symbols));
    }
}
