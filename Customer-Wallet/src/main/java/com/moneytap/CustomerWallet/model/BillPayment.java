package com.moneytap.CustomerWallet.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class BillPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int billId;
    private String billType;
    private int amount;
    private LocalDate date;


    @ManyToOne
    @JoinColumn(name="walletId")
    private Wallet wallet;

    @ManyToOne
    @JoinColumn(name="accountNumber")
    private BankAccount bankAccount;

    public BillPayment() {
    }

    public BillPayment(int billId, String billType, int amount, LocalDate date, Wallet wallet, BankAccount bankAccount) {
        this.billId = billId;
        this.billType = billType;
        this.amount = amount;
        this.date = date;
        this.wallet = wallet;
        this.bankAccount = bankAccount;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
        return "BillPayment{" +
                "billId=" + billId +
                ", billType='" + billType + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", wallet=" + wallet +
                ", bankAccount=" + bankAccount +
                '}';
    }
}
