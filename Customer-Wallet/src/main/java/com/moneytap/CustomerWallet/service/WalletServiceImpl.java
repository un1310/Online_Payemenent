package com.moneytap.CustomerWallet.service;

import com.moneytap.CustomerWallet.Exceptions.InsufficientFundException;
import com.moneytap.CustomerWallet.Exceptions.InvalidIdRequestedException;
import com.moneytap.CustomerWallet.Exceptions.minimumBalance;
import com.moneytap.CustomerWallet.model.BankAccount;
import com.moneytap.CustomerWallet.model.BillPayment;
import com.moneytap.CustomerWallet.model.Transaction;
import com.moneytap.CustomerWallet.model.Wallet;
import com.moneytap.CustomerWallet.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class WalletServiceImpl implements WalletService{
    @Autowired
    WalletRepository walletRepository;
    @Autowired
    BankAccountRepository bankAccountRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BeneficiaryDetailsRepository beneficiaryDetailsRepository;
    @Autowired
    BillPaymentRepository billPaymentRepository;

    @Override
    public List<Wallet> getWallet() {
        List<Wallet>walletList = new ArrayList<>();
        walletRepository.findAll().forEach(wallet -> walletList.add(wallet));
        return walletList;
    }

    @Override
    public Wallet addWallet(Wallet wallet) {
        walletRepository.save(wallet);
        return wallet;
    }

    @Override
    public void deleteWallet(Wallet wallet, Integer walletId) {
    walletRepository.deleteById(walletId);
    }

    @Override
    public void addBalance(Integer walletId,Integer money,Integer accountNumber) {
try {
    if(!walletRepository.findById(walletId).isPresent()){
        throw new InvalidIdRequestedException("The wallet id : "+walletId+" doesn't exist !!!!");
    }
    else {
        if(!bankAccountRepository.findById(accountNumber).isPresent()){
            throw new InvalidIdRequestedException("The bank account number : "+accountNumber+" doesn't exist");
        }
        else {
            BankAccount bankAccount = bankAccountRepository.findById(accountNumber).get();
            if(bankAccount.getBalance()<money){
                throw new InsufficientFundException("Your account Balance : "+bankAccount.getBalance()+" is less than amount: "+money+ " requested");
            }
            else if (bankAccount.getBalance()-money<1000){
                throw new minimumBalance("Your balance after this transaction : "+(bankAccount.getBalance()-money)+" which is less than desired minimum balance :"+1000);
            }
            else {
                bankAccount.setBalance(bankAccount.getBalance() - money);
                bankAccountRepository.save(bankAccount);


                Wallet wallet1 = walletRepository.findById(walletId).get();
                wallet1.setBalance(wallet1.getBalance() + money);
                walletRepository.save(wallet1);


                LocalDate date = LocalDate.now();
                Random random = new Random();
                int y = random.nextInt(10000);
                transactionRepository.save(new Transaction(y, "Credit", date, money, "Amount " + money + " added to wallet ", wallet1, bankAccount));
            }
        }
    }
}catch (Exception e){
    e.printStackTrace();
}
    }

    @Override
    public void sendBalance(Integer walletId, Integer money, Integer accountNumber) {
        try {
            if(!walletRepository.findById(walletId).isPresent()){
                throw new InvalidIdRequestedException("The wallet Id : " +walletId+" doesn't exist");
            }
            else {
                if (!bankAccountRepository.findById(accountNumber).isPresent()) {
                    throw new InvalidIdRequestedException("The bank account number: " + accountNumber + " is not Valid !!!");
                } else {
                    Wallet wallet1 = walletRepository.findById(walletId).get();
                    if (wallet1.getBalance() < money) {
                        throw new InsufficientFundException("The money requested: " + money + " is more than the current balance: " + wallet1.getBalance());
                    } else if (wallet1.getBalance() - money < 0) {
                        throw new minimumBalance("Wallet Balance can't be less than 0");
                    } else {
                        wallet1.setBalance(wallet1.getBalance() - money);
                        walletRepository.save(wallet1);

                        BankAccount bankAccount = bankAccountRepository.findById(accountNumber).get();
                        bankAccount.setBalance(bankAccount.getBalance() + money);
                        bankAccountRepository.save(bankAccount);


                        LocalDate date = LocalDate.now();
                        Random random = new Random();
                        int y = random.nextInt(50000);
                        transactionRepository.save(new Transaction(y, "Debit", date, money, "Amount " + money + " debited from wallet", wallet1, bankAccount));
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void sendMoneyToBeneficiary(Integer walletId, Integer money, Integer beneficiaryAccountNumber,Integer accountNumber) {

        try {
            if (!walletRepository.findById(walletId).isPresent()) {
                throw new InvalidIdRequestedException("The wallet Id : " + walletId + " doesn't exist");
            } else {
                if (!beneficiaryDetailsRepository.findById(beneficiaryAccountNumber).isPresent()) {
                    throw new InvalidIdRequestedException("The beneficiary :" + beneficiaryAccountNumber + " you are trying to doesn't exist !!!");
                } else {

                    Wallet wallet1 = walletRepository.findById(walletId).get();
                    if (wallet1.getBalance() < money) {
                        throw new InsufficientFundException("The money to be send : " + money + " exceeds the wallet balance !!!");
                    } else if (wallet1.getBalance() - money < 0) {
                        throw new minimumBalance("Wallet balance after this transaction will be less than zero, therefore denied !!!!");
                    } else {
                        wallet1.setBalance(wallet1.getBalance() - money);
                        walletRepository.save(wallet1);
                        LocalDate date = LocalDate.now();
                        BankAccount bankAccount = bankAccountRepository.findById(accountNumber).get();

                        BankAccount beneficiary = bankAccountRepository.findById(beneficiaryAccountNumber).get();
                        beneficiary.setBalance(beneficiary.getBalance()+money);
                        bankAccountRepository.save(beneficiary);
                        Wallet beneficiaryWallet = beneficiary.getWallet();
                        Random random = new Random();
                        int y = random.nextInt(100000);
                        transactionRepository.save(new Transaction(y, "Debit", date, money, "Amount " + money + " send to beneficiary "+beneficiaryAccountNumber, wallet1, bankAccount));
                        transactionRepository.save(new Transaction(y,"Credit",date,money,"Amount "+money+" received from Account holder "+ accountNumber,beneficiaryWallet,beneficiary));
                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void buyProduct(Integer walletId, String productName, Integer productCost, Integer accountNumber) {

        try {
            if (!walletRepository.findById(walletId).isPresent()) {
                throw new InvalidIdRequestedException("The wallet Id : " + walletId + " doesn't exist");
            } else {


                    Wallet wallet1 = walletRepository.findById(walletId).get();

                    if (wallet1.getBalance() < productCost) {
                        throw new InsufficientFundException("The Product Cost : " + productCost + " exceeds the wallet balance !!!");
                    } else if (wallet1.getBalance() - productCost < 0) {
                        throw new minimumBalance("Wallet balance after this transaction will be less than zero, therefore denied !!!!");
                    } else {
                        wallet1.setBalance(wallet1.getBalance() - productCost);
                        walletRepository.save(wallet1);
                        LocalDate date = LocalDate.now();
                        BankAccount bankAccount = bankAccountRepository.findById(accountNumber).get();
                        Random random = new Random();
                        int y = random.nextInt(10000);

                        transactionRepository.save(new Transaction(y, "Debit", date, productCost, productName+" " + " was bought !!!", wallet1, bankAccount));
                        billPaymentRepository.save(new BillPayment(100,productName,productCost,date,wallet1,bankAccount));
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void senMoneyToWallet(Integer accountNumber,Integer walletId, Integer beneficiaryAccountNumber,Integer beneficiaryWalletId, Integer money) {
        try{
            if(!walletRepository.findById(walletId).isPresent()){
                throw new InvalidIdRequestedException("The wallet Id : " + walletId + " doesn't exist");
            }
            else{
                if(!walletRepository.findById(beneficiaryWalletId).isPresent()){
                    throw new InvalidIdRequestedException("The beneficiary wallet Id : " + walletId + " doesn't exist");
                }
                else{
                    Wallet senderWallet = walletRepository.findById(walletId).get();
                    Wallet receiverWallet= walletRepository.findById(beneficiaryWalletId).get();
                    if (senderWallet.getBalance() < money) {
                        throw new InsufficientFundException("The money to be send : " + money + " exceeds the wallet balance !!!");
                    } else if (senderWallet.getBalance() - money < 0) {
                        throw new minimumBalance("Wallet balance after this transaction will be less than zero, therefore denied !!!!");
                    } else {
                        senderWallet.setBalance(senderWallet.getBalance() - money);
                        walletRepository.save(senderWallet);

                        receiverWallet.setBalance(receiverWallet.getBalance()+money);
                        walletRepository.save(receiverWallet);

                        BankAccount senderBankAccount = bankAccountRepository.findById(accountNumber).get();
                        BankAccount receiverBankAccount=bankAccountRepository.findById(beneficiaryAccountNumber).get();

                        Random random = new Random();
                        int y = random.nextInt(100000);
                        LocalDate date = LocalDate.now();
                        transactionRepository.save(new Transaction(y, "Debit", date, money, "Amount " + money + " send to beneficiary with wallet id : "+beneficiaryWalletId, senderWallet, senderBankAccount));
                        transactionRepository.save(new Transaction(y,"Credit",date,money,"Amount "+money+" received from Account holder "+ walletId,receiverWallet,receiverBankAccount));
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Autowired
    JWTRepository jwtRepository;
    @Override
    public String logout() {

        jwtRepository.deleteAll();
        return "Session Terminated";
    }
}
