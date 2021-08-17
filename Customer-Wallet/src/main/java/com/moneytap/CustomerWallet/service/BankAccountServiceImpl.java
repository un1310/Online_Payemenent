package com.moneytap.CustomerWallet.service;

import com.moneytap.CustomerWallet.model.BankAccount;
import com.moneytap.CustomerWallet.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService{
    @Autowired
    BankAccountRepository bankAccountRepository;
    @Override
    public List<BankAccount> getBankAccount() {
        List<BankAccount> bankAccountList = new ArrayList<>();
        bankAccountRepository.findAll().forEach(bankAccount -> bankAccountList.add(bankAccount));
        return bankAccountList;
    }

    @Override
    public BankAccount addBankaccount(BankAccount bankAccount) {
        bankAccountRepository.save(bankAccount);
        return bankAccount;
    }

    @Override
    public void deleteBankAccount(BankAccount bankAccount, Integer accountNumber) {
    bankAccountRepository.deleteById(accountNumber);
    }
}
