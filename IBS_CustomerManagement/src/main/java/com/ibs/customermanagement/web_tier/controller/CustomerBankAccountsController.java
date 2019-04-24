package com.ibs.customermanagement.web_tier.controller;

import com.ibs.customermanagement.service_tier.model.CustomerBankAccountsDTO;
import com.ibs.customermanagement.service_tier.service.CustomerBankAccountsService;
import com.ibs.customermanagement.web_tier.handlers.http_exceptions.UnprocessableEntityException;
import com.ibs.customermanagement.web_tier.response.BaseRequestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public BaseRequestResponse openBankAccount(@RequestBody CustomerBankAccountsDTO customerBankAccountsDTO) {
        if(customerBankAccountsDTO == null) {
            throw new UnprocessableEntityException("The requested body is null");
        }
        return customerBankAccountsService.saveCustomerBankAccount(customerBankAccountsDTO);
    }

    @DeleteMapping(value = "/delete-bank-account/{accountId}")
    public BaseRequestResponse deleteBankAccount(@PathVariable Integer accountId) {
        if(accountId == null) {
            throw new UnprocessableEntityException("The requested account id cannot be null");
        }
        return customerBankAccountsService.deleteCustomerBankAccount(accountId);
    }
}
