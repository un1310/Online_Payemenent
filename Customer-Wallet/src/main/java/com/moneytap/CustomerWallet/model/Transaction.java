package com.moneytap.CustomerWallet.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int serialId;
    private int transactionId;
    private String transactionType;
    private LocalDate transactionDate;
    private int amount;
    private String description;

    @ManyToOne
    @JoinColumn(name="walletId")
    private Wallet wallet;

    @ManyToOne
    @JoinColumn(name="accountNumber")
    private BankAccount bankAccount;

    public Transaction() {
    }

    public Transaction(int transactionId, String transactionType, LocalDate transactionDate, int amount, String description, Wallet wallet, BankAccount bankAccount) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.description = description;
        this.wallet = wallet;
        this.bankAccount = bankAccount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", transactionType='" + transactionType + '\'' +
                ", transactionDate=" + transactionDate +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", wallet=" + wallet +
                ", bankAccount=" + bankAccount +
                '}';
    }
}
