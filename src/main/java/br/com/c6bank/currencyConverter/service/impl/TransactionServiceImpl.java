package br.com.c6bank.currencyConverter.service.impl;

import br.com.c6bank.currencyConverter.model.entity.ExchangeRates;
import br.com.c6bank.currencyConverter.model.entity.Transaction;
import br.com.c6bank.currencyConverter.model.repository.TransactionRepository;
import br.com.c6bank.currencyConverter.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Double calculateRate(ExchangeRates rates, Transaction transaction) {

        String currencyOrigin = transaction.getCurrencyOrigin();
        String currencyDestination= transaction.getCurrencyDestination();
        Double rate;

        if(currencyOrigin.equals(rates.getBase())){
            rate=rates.getRates().get(currencyDestination);

        }else{
            Double rateOrigin = rates.getRates().get(currencyOrigin);
            Double rateDestination = rates.getRates().get(currencyDestination);

            rate=rateDestination/rateOrigin;
        }

        return rate;
    }

    @Override
    public List<Transaction> findAllByUserID(Long userID) {

        return transactionRepository.findAllByUserID(userID);
    }
}
