package br.com.c6bank.currencyConverter.service.impl;


import br.com.c6bank.currencyConverter.model.entity.Transaction;
import br.com.c6bank.currencyConverter.model.entity.AmountConverter;
import br.com.c6bank.currencyConverter.service.TransactionConverterService;
import org.springframework.stereotype.Service;

@Service
public class TransactionConverterServiceImpl implements TransactionConverterService {





    @Override
    public AmountConverter converterTransaction(Transaction transaction) {


        AmountConverter amountConverter = new AmountConverter();

        amountConverter.setAmountDestination(
                transaction.getAmountOrigin()*transaction.getRateConversion()
                );
        return amountConverter;
    }


}
