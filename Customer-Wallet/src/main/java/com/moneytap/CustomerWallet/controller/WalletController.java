package com.moneytap.CustomerWallet.controller;

import com.moneytap.CustomerWallet.model.Transaction;
import com.moneytap.CustomerWallet.model.Wallet;
import com.moneytap.CustomerWallet.repository.JWTRepository;
import com.moneytap.CustomerWallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class WalletController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private WalletService walletService;

    @Autowired
    private JWTRepository jwtRepository;

    @RequestMapping(method = RequestMethod.GET,value="/Wallet")
    List<Wallet> getWallet(){
        return walletService.getWallet();
    }

    @RequestMapping(method = RequestMethod.POST,value="/addWallet")
    public void addWallet(@RequestBody Wallet wallet){
        walletService.addWallet(wallet);
    }

    @RequestMapping(method=RequestMethod.POST,value = "/addMoney/{accountNumber}/{walletId}/{money}")
    public void addMoneyToWallet(@RequestBody Wallet wallet, @PathVariable Integer accountNumber,@PathVariable Integer walletId, @PathVariable Integer money){
        walletService.addBalance(walletId,money,accountNumber);
    }

    @RequestMapping(method=RequestMethod.POST,value = "/sendMoney/{accountNumber}/{walletId}/{money}")
    public void sendMoneyToAccount(@RequestBody Wallet wallet, @PathVariable Integer accountNumber,@PathVariable Integer walletId, @PathVariable Integer money){
        walletService.sendBalance(walletId,money,accountNumber);
    }

    @RequestMapping(method=RequestMethod.POST,value = "/addMoney/{accountNumber}/{beneficiaryAccountNumber}/{walletId}/{money}")
    public void addMoneyToBeneficiary(@RequestBody Wallet wallet, @PathVariable Integer accountNumber,@PathVariable Integer beneficiaryAccountNumber,@PathVariable Integer walletId, @PathVariable Integer money){
        walletService.sendMoneyToBeneficiary(walletId,money,beneficiaryAccountNumber,accountNumber);
    }
    @RequestMapping(method=RequestMethod.POST,value="/sendMoneyWallet/{accountNumber}/{walletId}/{beneficiaryAccountNumber}/{beneficiaryWalletId}/{money}")
    public void sendMoneyToWallet(@RequestBody Wallet wallet,@PathVariable Integer accountNumber,@PathVariable Integer walletId,@PathVariable Integer beneficiaryAccountNumber,@PathVariable Integer beneficiaryWalletId,Integer money){
        walletService.senMoneyToWallet(accountNumber,walletId,beneficiaryAccountNumber,beneficiaryWalletId,money);
    }
    @RequestMapping(method = RequestMethod.POST,value="/billPayment/{walletId}/{ProductName}/{ProductCost}/{accountNumber}")
    public void buyProduct(@RequestBody Wallet wallet,@PathVariable Integer walletId, @PathVariable String ProductName, @PathVariable Integer ProductCost, @PathVariable Integer accountNumber){
    walletService.buyProduct(walletId,ProductName,ProductCost,accountNumber);
    }
    @RequestMapping("/transactions/{walletId}")
    public Transaction getTransaction(@PathVariable Integer walletId){
        return restTemplate.getForObject("http://Transaction-for-payment/transactions/"+walletId,Transaction.class);
    }
    @GetMapping("/WalletLogOut")
    public String sessionLogout(){

        return walletService.logout();
    }
}
