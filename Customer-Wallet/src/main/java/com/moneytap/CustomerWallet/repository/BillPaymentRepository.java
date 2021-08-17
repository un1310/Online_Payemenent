package com.moneytap.CustomerWallet.repository;

import com.moneytap.CustomerWallet.model.BillPayment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillPaymentRepository extends CrudRepository<BillPayment,Integer> {
}
