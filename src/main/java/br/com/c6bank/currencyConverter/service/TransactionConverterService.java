package br.com.c6bank.currencyConverter.service;

import br.com.c6bank.currencyConverter.model.dto.CurrencyConverterView;
import br.com.c6bank.currencyConverter.model.entity.Transaction;
import br.com.c6bank.currencyConverter.model.entity.TransactionConverter;

import java.util.List;

public interface TransactionConverterService  {

    TransactionConverter converterTransaction( Transaction transaction);

    List<Transaction> findAllByUserID(Long userID);



}
