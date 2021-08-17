package com.moneytap.CustomerWallet.repository;

import com.moneytap.CustomerWallet.model.Wallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends CrudRepository<Wallet,Integer> {
}
