package com.moneytap.CustomerWallet.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wallet {
    @Id
    private int walletId;
    private int balance;
    public Wallet() {
    }

    public Wallet(int walletId, int balance) {
        this.walletId = walletId;
        this.balance = balance;
    }

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "walletId=" + walletId +
                ", balance=" + balance +
                '}';
    }
}
