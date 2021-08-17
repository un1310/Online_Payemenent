package com.moneytap.CustomerWallet.service;

import com.moneytap.CustomerWallet.model.BeneficiaryDetails;

import java.util.List;

public interface BeneficiaryDetailsService {
    List<BeneficiaryDetails> getBeneficiaryDetails();
    BeneficiaryDetails addBeneficiaryDetails(BeneficiaryDetails beneficiaryDetails);
    void deleteBeneficiaryDetails(BeneficiaryDetails beneficiaryDetails, Integer beneficiaryId);
}
