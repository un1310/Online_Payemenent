package com.moneytap.CustomerWallet.Exceptions;

public class InvalidIdRequestedException extends Exception{
    public InvalidIdRequestedException(String message){
        super(message);
    }
}
