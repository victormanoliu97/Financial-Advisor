package com.ibs.customermanagement.service_tier.service.bank_accounts;

import com.ibs.customermanagement.service_tier.model.CustomerBankAccountsDTO;
import com.ibs.customermanagement.web_tier.response.BaseRequestResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerBankAccountsService {

    List<CustomerBankAccountsDTO> getCustomerBankAccounts(Integer customerId);

    BaseRequestResponse saveCustomerBankAccount(CustomerBankAccountsDTO customerBankAccountsModel);

    BaseRequestResponse deleteCustomerBankAccount(Integer accountId);
}
