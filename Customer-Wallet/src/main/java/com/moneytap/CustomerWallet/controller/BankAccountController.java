package com.moneytap.CustomerWallet.controller;

import com.moneytap.CustomerWallet.model.BankAccount;
import com.moneytap.CustomerWallet.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;

    @RequestMapping(method = RequestMethod.GET, value="/BankAccount")
    List<BankAccount> getBankAccount(){return bankAccountService.getBankAccount();}

    @RequestMapping(method= RequestMethod.POST,value="/addBankAccount")
    public void addBankAccount(@RequestBody BankAccount bankAccount){
        bankAccountService.addBankaccount(bankAccount);
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/BankAccount/{accountNumber}")
    public void deleteBankAccount(@RequestBody BankAccount bankAccount,@PathVariable int accountNumber){
        bankAccountService.deleteBankAccount(bankAccount,accountNumber);
    }
}
