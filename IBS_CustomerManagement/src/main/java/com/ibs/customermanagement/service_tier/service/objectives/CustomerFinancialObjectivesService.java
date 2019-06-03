package com.ibs.customermanagement.service_tier.service.objectives;

import com.ibs.customermanagement.service_tier.model.CustomerFinancialObjectiveRequestDTO;
import com.ibs.customermanagement.service_tier.model.CustomerFinancialObjectiveResponseDTO;
import com.ibs.customermanagement.web_tier.response.BaseRequestResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerFinancialObjectivesService {

    List<CustomerFinancialObjectiveResponseDTO> getCustomerObjectives(Integer customerId);

    BaseRequestResponse saveCustomerObjective(CustomerFinancialObjectiveRequestDTO objectiveDTO);

    BaseRequestResponse deleteCustomerObjective(Integer id);

    BaseRequestResponse updateCustomerObjective(CustomerFinancialObjectiveRequestDTO objectiveDTO);

    CustomerFinancialObjectiveResponseDTO getObjectiveById(Integer id);

}
