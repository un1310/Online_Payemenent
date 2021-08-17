package com.moneytap.CustomerWallet.service;

import com.moneytap.CustomerWallet.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();
    Customer addCustomer(Customer customer);
    void deleteCustomer(Customer customer, Integer customerId);


}
