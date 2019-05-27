package com.ibs.customermanagement.web_tier.controller;

import com.ibs.customermanagement.service_tier.mapper.CustomerEstatesMapper;
import com.ibs.customermanagement.service_tier.model.CustomerEstatesDTO;
import com.ibs.customermanagement.service_tier.service.estates.CustomerEstatesService;
import com.ibs.customermanagement.web_tier.handlers.http_exceptions.ResourceNotFoundException;
import com.ibs.customermanagement.web_tier.response.BaseRequestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerEstatesController {

    private final CustomerEstatesService customerEstatesService;

    @Autowired
    public CustomerEstatesController(CustomerEstatesService customerEstatesService) {
        this.customerEstatesService = customerEstatesService;
    }

    @GetMapping(value = "/get-customer-estates/{customerId}")
    public List<CustomerEstatesDTO> getCustomerEstates(@PathVariable Integer customerId) {
        return customerEstatesService.getCustomerEstates(customerId);
    }

    @PostMapping(value = "/save-customer-estate")
    public BaseRequestResponse saveCustomerEstate(@RequestBody CustomerEstatesDTO customerEstatesDTO) {
        return customerEstatesService.saveCustomerEstate(customerEstatesDTO);
    }

    @DeleteMapping(value = "/delete-customer-estate/{estateId}")
    public BaseRequestResponse deleteCustomerEstate(@PathVariable Integer estateId) {
        return customerEstatesService.deleteCustomerEstate(estateId);
    }

    @PutMapping(value = "/update-customer-estate/{estateId}")
    public BaseRequestResponse updateCustomerEstate(@PathVariable("estateId") Integer estateId, @RequestBody CustomerEstatesDTO customerEstatesDTO) {
        if(!estateId.equals(customerEstatesDTO.getEstateId())) {
            throw new ResourceNotFoundException("The id is not the same with id from object");
        }
        CustomerEstatesDTO estateDB = customerEstatesService.getEstateById(estateId);
        if(estateDB == null) {
            throw new ResourceNotFoundException("Not found");
        }
        CustomerEstatesMapper customerEstatesMapper = new CustomerEstatesMapper();
        customerEstatesMapper.mergeEntities(estateDB, customerEstatesDTO);
        return customerEstatesService.saveCustomerEstate(estateDB);
    }
}
