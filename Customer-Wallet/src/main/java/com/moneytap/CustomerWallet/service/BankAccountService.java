package com.moneytap.CustomerWallet.service;

import com.moneytap.CustomerWallet.model.BankAccount;

import java.util.List;

public interface BankAccountService {
    List<BankAccount> getBankAccount();
    BankAccount addBankaccount(BankAccount bankAccount);
    void deleteBankAccount(BankAccount bankAccount, Integer accountNumber);
}
