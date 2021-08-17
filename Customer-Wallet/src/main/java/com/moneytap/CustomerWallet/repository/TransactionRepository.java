package com.moneytap.CustomerWallet.repository;

import com.moneytap.CustomerWallet.model.Transaction;
import com.moneytap.CustomerWallet.model.Wallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction,Integer> {

    public List<Transaction> findAllByWallet(Wallet wallet);
    public List<Transaction> findAllByTransactionDate(LocalDate date);
}
