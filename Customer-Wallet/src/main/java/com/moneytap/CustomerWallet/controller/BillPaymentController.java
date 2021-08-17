package com.moneytap.CustomerWallet.controller;

import com.moneytap.CustomerWallet.model.BillPayment;
import com.moneytap.CustomerWallet.service.BillPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class BillPaymentController {
    @Autowired
    BillPaymentService billPaymentService;
    @RequestMapping(method = RequestMethod.GET,value="/viewBillPament")
    List<BillPayment> getBillPayment(){
        return billPaymentService.getBillPayment();
    }

    @RequestMapping(method=RequestMethod.POST,value="/addBillPayment")
    public void addBillPayment(@RequestBody BillPayment billPayment){
      billPaymentService.addBillPayment(billPayment);
    }
}
