package com.ibs.customermanagement.service_tier.service.income;

import com.ibs.customermanagement.service_tier.model.CustomerFinancialIncomeDTO;
import com.ibs.customermanagement.web_tier.response.BaseRequestResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerFinancialIncomeService {

    List<CustomerFinancialIncomeDTO> getCustomerFinancialIncomes(Integer customerId);

    BaseRequestResponse saveCustomerFinancialIncomeEntry(CustomerFinancialIncomeDTO customerFinancialIncomeDTO);

    BaseRequestResponse deleteCustomerFinancialIncomeEntity(Integer incomeId);
}
