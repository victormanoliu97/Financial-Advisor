package com.ibs.customermanagement.web_tier.controller;

import com.ibs.customermanagement.service_tier.model.CustomerBankAccountsDTO;
import com.ibs.customermanagement.service_tier.service.CustomerBankAccountsService;
import com.ibs.customermanagement.web_tier.handlers.http_exceptions.UnprocessableEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerBankAccountsController {

    private final CustomerBankAccountsService customerBankAccountsService;

    @Autowired
    public CustomerBankAccountsController(CustomerBankAccountsService customerBankAccountsService) {
        this.customerBankAccountsService = customerBankAccountsService;
    }

    @GetMapping(value = "/customer-bank-accounts/{customerId}")
    public List<CustomerBankAccountsDTO> getCustomerBankAccounts(@PathVariable Integer customerId) {
        if(customerId == null) {
            throw new UnprocessableEntityException("The requested parameter is null");
        }
        return customerBankAccountsService.getCustomerBankAccounts(customerId);
    }

    @PostMapping(value = "/create-bank-account")
    public void openBankAccount(@RequestBody CustomerBankAccountsDTO customerBankAccountsDTO) {
        if(customerBankAccountsDTO == null) {
            throw new UnprocessableEntityException("The requested body is null");
        }
        customerBankAccountsService.saveCustomerBankAccount(customerBankAccountsDTO);
    }
}
