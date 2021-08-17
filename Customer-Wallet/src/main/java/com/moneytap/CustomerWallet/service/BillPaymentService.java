package com.moneytap.CustomerWallet.service;

import com.moneytap.CustomerWallet.model.BillPayment;

import java.util.List;

public interface BillPaymentService{
    List<BillPayment> getBillPayment();
    BillPayment addBillPayment(BillPayment billPayment);
    void deleteBillPayment(BillPayment billPayment, Integer billId);
}
