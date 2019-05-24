package com.ibs.customermanagement.web_tier.controller;

import com.ibs.customermanagement.service_tier.mapper.CustomerFinancialLiabilitiesMapper;
import com.ibs.customermanagement.service_tier.model.CustomerFinancialLiabilitiesDTO;
import com.ibs.customermanagement.service_tier.service.liabilities.CustomerFinancialLiabilitiesService;
import com.ibs.customermanagement.web_tier.handlers.http_exceptions.UnprocessableEntityException;
import com.ibs.customermanagement.web_tier.response.BaseRequestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerLiabilityController {

    private final CustomerFinancialLiabilitiesService customerFinancialLiabilitiesService;

    @Autowired
    public CustomerLiabilityController(CustomerFinancialLiabilitiesService customerFinancialLiabilitiesService) {
        this.customerFinancialLiabilitiesService = customerFinancialLiabilitiesService;
    }

    @GetMapping(value = "/get-customer-liabilities/{customerId}")
    public List<CustomerFinancialLiabilitiesDTO> getCustomerLiabilities(@PathVariable Integer customerId) {
        if(customerId == null) {
            throw new UnprocessableEntityException("The requested parameter is null");
        }
        return customerFinancialLiabilitiesService.getCustomerFinancialLiabilities(customerId);
    }

    @PostMapping(value = "/create-customer-liability")
    public BaseRequestResponse saveCustomerLiability(@RequestBody CustomerFinancialLiabilitiesDTO customerFinancialLiabilitiesDTO) {
        return customerFinancialLiabilitiesService.saveCustomerFinancialLiability(customerFinancialLiabilitiesDTO);
    }

    @PutMapping(value = "/update-customer-liability/{liabilityId}")
    public BaseRequestResponse updateCustomerLiability(@PathVariable("liabilityId") Integer liabilityId, @RequestBody CustomerFinancialLiabilitiesDTO customerFinancialLiabilitiesDTO) {
        if(!liabilityId.equals(customerFinancialLiabilitiesDTO.getIdFinancialLiability())) {
            return new BaseRequestResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        CustomerFinancialLiabilitiesDTO liabilityDB = customerFinancialLiabilitiesService.getLiabilityById(liabilityId);
        if(liabilityDB == null) {
            return new BaseRequestResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase());
        }
        CustomerFinancialLiabilitiesMapper customerFinancialLiabilitiesMapper = new CustomerFinancialLiabilitiesMapper();
        customerFinancialLiabilitiesMapper.mergeEntities(liabilityDB, customerFinancialLiabilitiesDTO);
        return customerFinancialLiabilitiesService.updateCustomerFinancialLiability(liabilityDB);
    }

    @DeleteMapping(value = "/delete-customer-liability/{liabilityId}")
    public BaseRequestResponse deleteCustomerLiability(@PathVariable("liabilityId") Integer liabilityId) {
        if(liabilityId == null) {
            return new BaseRequestResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return customerFinancialLiabilitiesService.deleteCustomerFinancialLiability(liabilityId);
    }
}
