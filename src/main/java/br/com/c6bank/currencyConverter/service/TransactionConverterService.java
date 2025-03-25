package br.com.c6bank.currencyConverter.service;

import br.com.c6bank.currencyConverter.model.entity.Transaction;
import br.com.c6bank.currencyConverter.model.entity.AmountConverter;

public interface TransactionConverterService  {

    AmountConverter converterTransaction(Transaction transaction);





}
