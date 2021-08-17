package com.moneytap.CustomerWallet.service;

import com.moneytap.CustomerWallet.model.BeneficiaryDetails;
import com.moneytap.CustomerWallet.repository.BeneficiaryDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BeneficiaryDetailsServiceImpl implements BeneficiaryDetailsService{
    @Autowired
    BeneficiaryDetailsRepository beneficiaryDetailsRepository;

    @Override
    public List<BeneficiaryDetails> getBeneficiaryDetails() {
        List<BeneficiaryDetails> beneficiaryDetailsList = new ArrayList<>();
        beneficiaryDetailsRepository.findAll().forEach(beneficiaryDetails->beneficiaryDetailsList.add(beneficiaryDetails));
        return beneficiaryDetailsList;
    }

    @Override
    public BeneficiaryDetails addBeneficiaryDetails(BeneficiaryDetails beneficiaryDetails) {
        beneficiaryDetailsRepository.save(beneficiaryDetails);
        return beneficiaryDetails;
    }

    @Override
    public void deleteBeneficiaryDetails(BeneficiaryDetails beneficiaryDetails, Integer beneficiaryId) {
        beneficiaryDetailsRepository.deleteById(beneficiaryId);
    }
}
