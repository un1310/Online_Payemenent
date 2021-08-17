package com.moneytap.CustomerWallet.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BeneficiaryDetails {
    @Id
    private int beneficiaryAccountNumber;
    private String name;
    private long mobileNumber;


@ManyToOne
@JoinColumn(name="walletId")
    private Wallet wallet;

    public BeneficiaryDetails() {
    }

    public BeneficiaryDetails(int beneficiaryAccountNumber, String name, long mobileNumber, Wallet wallet) {
        this.beneficiaryAccountNumber = beneficiaryAccountNumber;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.wallet = wallet;
    }

    public int getBeneficiaryAccountNumber() {
        return beneficiaryAccountNumber;
    }

    public void setBeneficiaryAccountNumber(int beneficiaryAccountNumber) {
        this.beneficiaryAccountNumber = beneficiaryAccountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "BeneficiaryDetails{" +
                "beneficiaryAccountNumber=" + beneficiaryAccountNumber +
                ", name='" + name + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", wallet=" + wallet +
                '}';
    }
}
