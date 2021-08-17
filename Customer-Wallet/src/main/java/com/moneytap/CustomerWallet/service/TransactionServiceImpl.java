package com.moneytap.CustomerWallet.service;

import com.moneytap.CustomerWallet.model.Transaction;
import com.moneytap.CustomerWallet.repository.TransactionRepository;
import com.moneytap.CustomerWallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    WalletRepository walletRepository;

    @Override
    public List<Transaction> getAllTransaction() {

        List<Transaction> transactionList = new ArrayList<>();
        transactionRepository.findAll().forEach(transaction -> transactionList.add(transaction));
        return transactionList;
    }

    @Override
    public Transaction addTransaction(Transaction transaction, Integer transactionId) {
        transactionRepository.save(transaction);
        return transaction;
    }

    @Override
    public void deleteTransaction(Transaction transaction, Integer transactionId) {
    transactionRepository.deleteById(transactionId);
    }

    @Override
    public List<Transaction> getTransactionByWallet(Integer walletId) {
        return transactionRepository.findAllByWallet(walletRepository.findById(walletId).get());
    }

    @Override
    public List<Transaction> getTransactionByTransactionDate(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return transactionRepository.findAllByTransactionDate(localDate);
    }
}
