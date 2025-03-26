package br.com.c6bank.currencyConverter.service.impl;

import br.com.c6bank.currencyConverter.handler.BusinessException;
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

    //Calcula taxa que será utilizada na conversão
    @Override
    public Double calculateRate(ExchangeRates rates, Transaction transaction) {

        //Para ficar mais explicito e quebrar linhas, os valores foram alocados em variáveis antes da operação


        String currencyOrigin = transaction.getCurrencyOrigin();

        String currencyDestination= transaction.getCurrencyDestination();

        Double rate;

        //Verifica se a moeda de origem é igual a moeda base das taxas
        if(currencyOrigin.equalsIgnoreCase(rates.getBase())){

            rate=rates.getRates().get(currencyDestination);

        }else{
            //Moeda de origem sendo diferente da moeda base

            //Aqui ocorre calculo para determinar a taxa com base em duas moedas diferentes da moeda base


            Double rateOrigin = rates.getRates().get(currencyOrigin.toUpperCase());

            Double rateDestination = rates.getRates().get(currencyDestination.toUpperCase());

            if(rateOrigin == null){
                throw new BusinessException("Could not obtain rate of currencyOrigin: "+currencyOrigin);
            }

            if(rateDestination == null){
                throw new BusinessException("Could not obtain rate of currencyDestination: "+currencyDestination);
            }

            //Calculo da taxa da transação
            rate=rateDestination/rateOrigin;
        }

        return rate;
    }

    @Override
    public List<Transaction> findAllByUserID(Long userID) {

        List<Transaction> response = transactionRepository.findAllByUserID(userID);

        if(response.isEmpty()){
            throw new BusinessException("There are no transactions for the user ID "+userID);
        }

        return response;
    }
}
