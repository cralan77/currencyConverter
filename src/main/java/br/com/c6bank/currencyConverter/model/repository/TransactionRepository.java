package br.com.c6bank.currencyConverter.model.repository;

import br.com.c6bank.currencyConverter.model.entity.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    //Determina query qye será utilizada para filtrar todas as transações por usuário
    @Query(value = "SELECT * FROM Transaction T JOIN AMOUNT_CONVERTER TC ON T.id=TC.IDAMOUNTCONVERTER WHERE user_Id = ?1", nativeQuery = true)
    List<Transaction> findAllByUserID (Long userId);
}
