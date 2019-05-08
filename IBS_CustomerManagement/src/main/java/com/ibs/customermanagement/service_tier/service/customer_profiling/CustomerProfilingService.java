package com.ibs.customermanagement.service_tier.service.customer_profiling;

import com.ibs.customermanagement.service_tier.model.CustomerProfilingDTO;
import com.ibs.customermanagement.web_tier.response.BaseRequestResponse;
import org.springframework.stereotype.Service;

@Service
public interface CustomerProfilingService {

    CustomerProfilingDTO getCustomerProfiling(Integer customerId);

    BaseRequestResponse saveCustomerProfiling(CustomerProfilingDTO customerProfilingDTO);

    BaseRequestResponse updateCustomerProfiling(CustomerProfilingDTO customerProfilingDTO);
}
