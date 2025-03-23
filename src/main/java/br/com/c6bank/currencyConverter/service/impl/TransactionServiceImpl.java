package br.com.c6bank.currencyConverter.service.impl;

import br.com.c6bank.currencyConverter.model.entity.ExchangeRates;
import br.com.c6bank.currencyConverter.model.entity.Transaction;
import br.com.c6bank.currencyConverter.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private Transaction transaction;

    @Override
    public Transaction calculateRate(ExchangeRates rates) {

        String currencyOrigin = transaction.getCurrencyOrigin();
        String currencyDestination= transaction.getCurrencyDestination();

        if(currencyOrigin.equals(rates.getBase())){
            transaction.setRateConversion(rates.getRates().get(currencyDestination));

        }else{
            Double rateOrigin = rates.getRates().get(currencyOrigin);
            Double rateDestination = rates.getRates().get(currencyDestination);

            transaction.setRateConversion(rateDestination/rateOrigin);
        }

        return transaction;
    }
}
