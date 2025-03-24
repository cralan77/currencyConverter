package br.com.c6bank.currencyConverter.service;

import br.com.c6bank.currencyConverter.model.entity.ExchangeRates;
import br.com.c6bank.currencyConverter.model.entity.Transaction;

public interface TransactionService {

    Transaction calculateRate(ExchangeRates exchangeRates, Transaction transaction);
}
