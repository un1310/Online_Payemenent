package com.moneytap.CustomerWallet.controller;

import com.moneytap.CustomerWallet.model.Customer;
import com.moneytap.CustomerWallet.service.CustomerService;
import com.moneytap.CustomerWallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CustomerController {
    @Autowired
    CustomerService customerService;


    @RequestMapping(method = RequestMethod.GET, value = "/customers")

        List<Customer> getAllCustomer () {
        if (UserService.UserName.equals("Admin")) {
            return customerService.getAllCustomer();


        }
        else{
            return null;
    }
    }
@RequestMapping(method = RequestMethod.POST,value="/addCustomer")
public void addCustomer(@RequestBody Customer customer){
customerService.addCustomer(customer);
}

}
