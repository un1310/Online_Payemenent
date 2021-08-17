package com.moneytap.CustomerWallet.service;

import com.moneytap.CustomerWallet.model.Customer;
import com.moneytap.CustomerWallet.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        customerRepository.findAll().forEach(customer -> customerList.add(customer));
        return customerList;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public void deleteCustomer(Customer customer, Integer customerId) {
        customerRepository.deleteById(customerId);
    }


}
