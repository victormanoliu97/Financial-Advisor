package com.ibs.customermanagement.service_tier.service.liabilities;

import com.ibs.customermanagement.service_tier.model.CustomerFinancialLiabilitiesDTO;
import com.ibs.customermanagement.web_tier.response.BaseRequestResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerFinancialLiabilitiesService {

    List<CustomerFinancialLiabilitiesDTO> getCustomerFinancialLiabilities(Integer customerId);

    BaseRequestResponse saveCustomerFinancialLiability(CustomerFinancialLiabilitiesDTO customerFinancialLiabilitiesDTO);

    BaseRequestResponse deleteCustomerFinancialLiability(Integer liabilityId);

    BaseRequestResponse updateCustomerFinancialLiability(CustomerFinancialLiabilitiesDTO customerFinancialLiabilitiesDTO);

    CustomerFinancialLiabilitiesDTO getLiabilityById(Integer liabilityId);
}
