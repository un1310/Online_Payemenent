package com.moneytap.CustomerWallet.repository;

import com.moneytap.CustomerWallet.model.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {
}
