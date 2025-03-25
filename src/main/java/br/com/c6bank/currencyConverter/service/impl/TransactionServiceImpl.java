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

    //Calcula taxa que será utilizada na conversão
    @Override
    public Double calculateRate(ExchangeRates rates, Transaction transaction) {

        //Para ficar mais explicito e quebrar linhas, os valores foram alocados em variáveis antes da operação

        //Aloca moeda de origem
        String currencyOrigin = transaction.getCurrencyOrigin();

        //Aloca moeda de destino
        String currencyDestination= transaction.getCurrencyDestination();

        //variavel que receberá taxa calculada
        Double rate;

        //Verifica se a moeda de origem é igual a moeda base das taxas
        if(currencyOrigin.equals(rates.getBase())){
            //Aloca as taxas base como taxa da transação
            rate=rates.getRates().get(currencyDestination);

        }else{
            //Moeda de origem sendo diferente da moeda base

            //Aqui ocorre calculo para determinar a taxa com base em duas moedas diferentes da moeda base

            //Aloca taxa da moeda de origem
            Double rateOrigin = rates.getRates().get(currencyOrigin);

            //Aloca taxa da moeda de destino
            Double rateDestination = rates.getRates().get(currencyDestination);

            //Calculo da taxa da transação
            rate=rateDestination/rateOrigin;
        }

        return rate;
    }

    @Override
    public List<Transaction> findAllByUserID(Long userID) {

        return transactionRepository.findAllByUserID(userID);
    }
}
