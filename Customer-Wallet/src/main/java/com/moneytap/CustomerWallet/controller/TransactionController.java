package com.moneytap.CustomerWallet.controller;

import com.moneytap.CustomerWallet.model.Transaction;
import com.moneytap.CustomerWallet.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @RequestMapping(method= RequestMethod.GET,value="/transactions")
    List<Transaction> getAllTransaction(){
        return transactionService.getAllTransaction();
    }
    @RequestMapping(method = RequestMethod.GET,value="/transactions/{walletId}")
    List<Transaction> getTransactionByWalletId(@PathVariable Integer walletId){

        return transactionService.getTransactionByWallet(walletId);
    }
    @RequestMapping(method = RequestMethod.GET,value="/transactionsByDate/{date}")
    List<Transaction>getTransactionByDate(@PathVariable String date)
    {
        return transactionService.getTransactionByTransactionDate(date);
    }

}
