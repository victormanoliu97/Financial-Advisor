package com.ibs.customermanagement.service_tier.service.customer_profiling;

import com.ibs.customermanagement.service_tier.model.CustomerProfilingDTO;
import com.ibs.customermanagement.web_tier.response.BaseRequestResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerProfilingService {

    List<CustomerProfilingDTO> getCustomerProfiling(Integer customerId);

    BaseRequestResponse saveCustomerProfiling(CustomerProfilingDTO customerProfilingDTO);

    BaseRequestResponse updateCustomerProfiling(CustomerProfilingDTO customerProfilingDTO);

    CustomerProfilingDTO getByIdProfiling(Integer idProfiling);
}
