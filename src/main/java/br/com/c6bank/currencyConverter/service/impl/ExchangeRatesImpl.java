package br.com.c6bank.currencyConverter.service.impl;

import br.com.c6bank.currencyConverter.model.entity.ExchangeRates;
import br.com.c6bank.currencyConverter.service.ExchangeRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRatesImpl implements ExchangeRatesService {

    @Autowired
    private ExchangeRatesService exchangeRatesService;

    @Override
    public ExchangeRates exchangeRates(String symbols) {


        return exchangeRatesService.exchangeRates(symbols);
    }
}
