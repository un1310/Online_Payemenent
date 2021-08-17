package com.moneytap.CustomerWallet.controller;

import com.moneytap.CustomerWallet.model.BeneficiaryDetails;
import com.moneytap.CustomerWallet.service.BeneficiaryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class BeneficiaryDetailsController {
    @Autowired
    private BeneficiaryDetailsService beneficiaryDetailsService;

    @RequestMapping(method= RequestMethod.GET,value="/allBeneficiary")
    List<BeneficiaryDetails> getAllBeneficiaryDetails(){
        return beneficiaryDetailsService.getBeneficiaryDetails();
    }
    @RequestMapping(method=RequestMethod.POST,value ="/addBeneficiary")
    public void addBeneficiary(@RequestBody BeneficiaryDetails beneficiaryDetails){
        beneficiaryDetailsService.addBeneficiaryDetails(beneficiaryDetails);
    }

    @RequestMapping(method=RequestMethod.DELETE,value="/deleteBeneficiaryDetails/{beneficiaryId}")
    public void deleteBeneficiaryDetails(@RequestBody BeneficiaryDetails beneficiaryDetails, @PathVariable Integer beneficiaryId){
        beneficiaryDetailsService.deleteBeneficiaryDetails(beneficiaryDetails,beneficiaryId);
    }

}
