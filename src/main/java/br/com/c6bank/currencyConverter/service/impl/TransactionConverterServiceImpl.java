package br.com.c6bank.currencyConverter.service.impl;


import br.com.c6bank.currencyConverter.model.entity.Transaction;
import br.com.c6bank.currencyConverter.model.entity.TransactionConverter;
import br.com.c6bank.currencyConverter.service.TransactionConverterService;
import org.springframework.stereotype.Service;

@Service
public class TransactionConverterServiceImpl implements TransactionConverterService {





    @Override
    public TransactionConverter converterTransaction(Transaction transaction) {


        TransactionConverter transactionConverter = new TransactionConverter();

        transactionConverter.setAmountDestination(
                transaction.getAmountOrigin()*transaction.getRateConversion()
                );
        return transactionConverter;
    }


}
