package com.moneytap.CustomerWallet.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BankAccount {
    @Id
    private int accountNumber;
    private String IFSCCode;
    private String bankName;
    private int balance;

    @ManyToOne
    @JoinColumn(name="walletId")
    private Wallet wallet;

    public BankAccount() {
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public void setIFSCCode(String IFSCCode) {
        this.IFSCCode = IFSCCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", IFSCCode='" + IFSCCode + '\'' +
                ", bankName='" + bankName + '\'' +
                ", balance=" + balance +
                ", wallet=" + wallet +
                '}';
    }
}
