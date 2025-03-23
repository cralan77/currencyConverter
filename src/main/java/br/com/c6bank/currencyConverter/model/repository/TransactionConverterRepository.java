package br.com.c6bank.currencyConverter.model.repository;

import br.com.c6bank.currencyConverter.model.entity.TransactionConverter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionConverterRepository extends CrudRepository<TransactionConverter, Long> {

    @Query(value = "SELECT * FROM TRANSACTION T JOIN TRANSACTIONCONVERTER TC ON T.id=TC.transaction_id WHERE user_Id = ?1", nativeQuery = true)
    List<TransactionConverter> findAllByUserID (Long userId);
}
