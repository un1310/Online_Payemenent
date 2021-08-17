package com.moneytap.CustomerWallet.service;

import com.moneytap.CustomerWallet.model.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAllTransaction();
    Transaction addTransaction(Transaction transaction, Integer transactionId);
    void deleteTransaction(Transaction transaction,Integer transactionId);
    List<Transaction> getTransactionByWallet(Integer walletId);
    List<Transaction> getTransactionByTransactionDate(String date);
}
