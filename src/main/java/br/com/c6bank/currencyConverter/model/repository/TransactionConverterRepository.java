package br.com.c6bank.currencyConverter.model.repository;

import br.com.c6bank.currencyConverter.model.entity.TransactionConverter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionConverterRepository extends CrudRepository<TransactionConverter, Long> {


}
