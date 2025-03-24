package br.com.c6bank.currencyConverter.model.repository;

import br.com.c6bank.currencyConverter.model.dto.CurrencyConverterView;
import br.com.c6bank.currencyConverter.model.entity.Transaction;
import br.com.c6bank.currencyConverter.model.entity.TransactionConverter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionConverterRepository extends CrudRepository<TransactionConverter, Long> {

    @Query(value = "SELECT * FROM Transaction T JOIN TRANSACTION_CONVERTER TC ON T.id=TC.IDTRANSACTIONCONVERTER WHERE user_Id = ?1", nativeQuery = true)
    List<Transaction> findAllByUserID (Long userId);
}
