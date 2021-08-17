package com.moneytap.CustomerWallet.model;

import javax.persistence.*;

@Entity
public class Customer {

    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private long mobileNUmber;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="walletId")
    private Wallet wallet;

    public Customer() {
    }

    public Customer(String name, int customerId, long mobileNUmber, String password, Wallet wallet) {
        this.name = name;
        this.customerId = customerId;
        this.mobileNUmber = mobileNUmber;
        this.password = password;
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public long getMobileNUmber() {
        return mobileNUmber;
    }

    public void setMobileNUmber(long mobileNUmber) {
        this.mobileNUmber = mobileNUmber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", customerId=" + customerId +
                ", mobileNUmber=" + mobileNUmber +
                ", password='" + password + '\'' +
                ", wallet=" + wallet +
                '}';
    }
}
