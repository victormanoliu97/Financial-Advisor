package com.ibs.customermanagement.web_tier.controller;

import com.ibs.customermanagement.service_tier.mapper.CustomerProfilingMapper;
import com.ibs.customermanagement.service_tier.model.CustomerProfilingDTO;
import com.ibs.customermanagement.service_tier.service.customer_profiling.CustomerProfilingService;
import com.ibs.customermanagement.web_tier.handlers.http_exceptions.ResourceNotFoundException;
import com.ibs.customermanagement.web_tier.handlers.http_exceptions.UnprocessableEntityException;
import com.ibs.customermanagement.web_tier.response.BaseRequestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerProfilingController {

    private final CustomerProfilingService customerProfilingService;

    @Autowired
    public CustomerProfilingController(CustomerProfilingService customerProfilingService) {
        this.customerProfilingService = customerProfilingService;
    }

    @GetMapping(value = "/get-profiling/{id}")
    public List<CustomerProfilingDTO> getCustomerProfiling(@PathVariable("id") Integer customerId) {
        if(customerId == null) {
            throw new UnprocessableEntityException("The requested parameter is null");
        }
        return customerProfilingService.getCustomerProfiling(customerId);
    }


    @PostMapping(value = "/save-profiling")
    public BaseRequestResponse saveCustomerProfiling(@RequestBody CustomerProfilingDTO customerProfilingDTO) {
        if(customerProfilingDTO == null) {
            throw new UnprocessableEntityException("The requested body is null");
        }
        return customerProfilingService.saveCustomerProfiling(customerProfilingDTO);
    }

    @PutMapping(value = "update-profiling/{id}")
    public BaseRequestResponse updateCustomerProfiling(@PathVariable("id") Integer id, @RequestBody CustomerProfilingDTO customerProfilingDTO) {
        if(!id.equals(customerProfilingDTO.getIdCustomer())) {
            throw new ResourceNotFoundException("The id is not the same with id from object");
        }
        CustomerProfilingDTO profilingDB = customerProfilingService.getByIdProfiling(id);
        if(profilingDB == null) {
            throw new ResourceNotFoundException("Not found");
        }
        CustomerProfilingMapper customerProfilingMapper = new CustomerProfilingMapper();
        customerProfilingMapper.mergeEntities(profilingDB, customerProfilingDTO);
        return customerProfilingService.updateCustomerProfiling(profilingDB);
    }
}
