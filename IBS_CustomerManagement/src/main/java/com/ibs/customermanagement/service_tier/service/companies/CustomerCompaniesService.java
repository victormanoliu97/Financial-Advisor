package com.ibs.customermanagement.service_tier.service.companies;

import com.ibs.customermanagement.service_tier.model.CustomerCompaniesDTO;
import com.ibs.customermanagement.web_tier.response.BaseRequestResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerCompaniesService {

    List<CustomerCompaniesDTO> getCustomerCompanies(Integer customerId);

    BaseRequestResponse saveCustomerCompany(CustomerCompaniesDTO companiesDTO);

    BaseRequestResponse deleteCustomerCompany(Integer companyId);

    BaseRequestResponse updateCustomerCompany(CustomerCompaniesDTO companiesDTO);

    CustomerCompaniesDTO getCustomerCompanyById(Integer companyId);
}
