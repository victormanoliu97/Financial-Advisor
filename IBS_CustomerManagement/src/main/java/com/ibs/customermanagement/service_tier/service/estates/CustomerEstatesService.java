package com.ibs.customermanagement.service_tier.service.estates;

import com.ibs.customermanagement.service_tier.model.CustomerEstatesDTO;
import com.ibs.customermanagement.web_tier.response.BaseRequestResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerEstatesService {

    List<CustomerEstatesDTO> getCustomerEstates(Integer customerId);

    BaseRequestResponse saveCustomerEstate(CustomerEstatesDTO estatesDTO);

    BaseRequestResponse deleteCustomerEstate(Integer estateId);

    BaseRequestResponse updateCustomerEstate(CustomerEstatesDTO estatesDTO);

    CustomerEstatesDTO getEstateById(Integer estateId);
}
