package br.com.c6bank.currencyConverter.service.impl;


import br.com.c6bank.currencyConverter.model.dto.CurrencyConverterView;
import br.com.c6bank.currencyConverter.model.entity.Transaction;
import br.com.c6bank.currencyConverter.model.entity.TransactionConverter;
import br.com.c6bank.currencyConverter.model.repository.TransactionConverterRepository;
import br.com.c6bank.currencyConverter.service.ExchangeRatesService;
import br.com.c6bank.currencyConverter.service.TransactionConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionConverterServiceImpl implements TransactionConverterService {


    @Autowired
    private TransactionConverterRepository transactionConverterRepository;


    @Override
    public TransactionConverter converterTransaction(Transaction transaction) {


        TransactionConverter transactionConverter = new TransactionConverter();

        transactionConverter.setAmountDestination(
                transaction.getAmountOrigin()*transaction.getRateConversion()
                );
        return transactionConverter;
    }

    @Override
    public List<Transaction> findAllByUserID(Long userID) {

        return transactionConverterRepository.findAllByUserID(userID);
    }
}
