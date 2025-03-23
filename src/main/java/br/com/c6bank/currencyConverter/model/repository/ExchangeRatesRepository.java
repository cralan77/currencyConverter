package br.com.c6bank.currencyConverter.model.repository;

import br.com.c6bank.currencyConverter.model.entity.ExchangeRates;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRatesRepository extends CrudRepository<ExchangeRates, Long> {
}
