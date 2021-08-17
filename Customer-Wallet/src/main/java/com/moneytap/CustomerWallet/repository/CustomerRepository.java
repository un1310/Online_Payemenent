package com.moneytap.CustomerWallet.repository;

import com.moneytap.CustomerWallet.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    public Customer findByName(String name);
}
