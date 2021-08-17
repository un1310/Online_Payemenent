package com.moneytap.CustomerWallet.Exceptions;

public class InsufficientFundException extends Exception{
    public  InsufficientFundException(String message){
        super(message);
    }
}
