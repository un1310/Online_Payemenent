package com.moneytap.CustomerWallet.service;

import com.moneytap.CustomerWallet.model.Wallet;

import java.util.List;

public interface WalletService {
    List<Wallet> getWallet();
    Wallet addWallet(Wallet wallet);
    void deleteWallet(Wallet wallet,Integer walletId);
    void addBalance(Integer walletId,Integer balance,Integer accountNumber);
    void sendBalance(Integer walletId, Integer money, Integer accountNumber);
    void sendMoneyToBeneficiary(Integer walletId, Integer money, Integer beneficiaryAccountNumber,Integer accountNumber);
    void buyProduct(Integer walletId, String productName, Integer productCost,Integer accountNumber);
    void senMoneyToWallet(Integer accountNumber,Integer walletId, Integer beneficiaryAccountNumber,Integer beneficiaryWalletId, Integer money);

    String logout();
}
