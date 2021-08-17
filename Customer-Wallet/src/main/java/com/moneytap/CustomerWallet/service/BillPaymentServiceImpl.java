package com.moneytap.CustomerWallet.service;

import com.moneytap.CustomerWallet.model.BillPayment;
import com.moneytap.CustomerWallet.repository.BillPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillPaymentServiceImpl implements BillPaymentService{
    @Autowired
    BillPaymentRepository billPaymentRepository;
    @Override
    public List<BillPayment> getBillPayment() {
        List<BillPayment> billPaymentList = new ArrayList<>();
        billPaymentRepository.findAll().forEach(billPayment -> billPaymentList.add(billPayment));
        return billPaymentList;
    }

    @Override
    public BillPayment addBillPayment(BillPayment billPayment) {
        billPaymentRepository.save(billPayment);
        return billPayment;
    }

    @Override
    public void deleteBillPayment(BillPayment billPayment, Integer billId) {
        billPaymentRepository.deleteById(billId);
    }
}
