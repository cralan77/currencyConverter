package br.com.c6bank.currencyConverter.service;

import br.com.c6bank.currencyConverter.model.entity.ExchangeRates;
import br.com.c6bank.currencyConverter.model.entity.Transaction;

import java.util.List;

public interface TransactionService {

    Double calculateRate(ExchangeRates exchangeRates, Transaction transaction);

    List<Transaction> findAllByUserID(Long userID);
}
