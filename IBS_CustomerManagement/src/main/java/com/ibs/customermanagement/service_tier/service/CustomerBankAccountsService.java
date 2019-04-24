package com.ibs.customermanagement.service_tier.service;

import com.ibs.customermanagement.service_tier.model.CustomerBankAccountsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerBankAccountsService {

    List<CustomerBankAccountsDTO> getCustomerBankAccounts(Integer customerId);

    void saveCustomerBankAccount(CustomerBankAccountsDTO customerBankAccountsModel);

    void deleteCustomerBankAccount(Integer accountId);
}
