package com.moneytap.CustomerWallet.repository;

import com.moneytap.CustomerWallet.model.BeneficiaryDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryDetailsRepository extends CrudRepository<BeneficiaryDetails,Integer> {
}
