package com.ibs.customermanagement.web_tier.controller;

import com.ibs.customermanagement.service_tier.mapper.CustomerCompaniesMapper;
import com.ibs.customermanagement.service_tier.model.CustomerCompaniesDTO;
import com.ibs.customermanagement.service_tier.service.companies.CustomerCompaniesService;
import com.ibs.customermanagement.web_tier.handlers.http_exceptions.ResourceNotFoundException;
import com.ibs.customermanagement.web_tier.response.BaseRequestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CustomerCompaniesController {

    private final CustomerCompaniesService customerCompaniesService;

    @Autowired
    public CustomerCompaniesController(CustomerCompaniesService customerCompaniesService) {
        this.customerCompaniesService = customerCompaniesService;
    }

    @GetMapping(value = "/get-customer-companies/{customerId}")
    public List<CustomerCompaniesDTO> getCustomerCompanies(@PathVariable Integer customerId) {
        return customerCompaniesService.getCustomerCompanies(customerId);
    }

    @PostMapping(value = "/create-customer-company")
    public BaseRequestResponse saveCustomerCompany(@RequestBody CustomerCompaniesDTO companiesDTO) {
        return customerCompaniesService.saveCustomerCompany(companiesDTO);
    }

    @DeleteMapping(value = "/delete-customer-company")
    public BaseRequestResponse deleteCustomerCompany(@PathVariable Integer companyId) {
        return customerCompaniesService.deleteCustomerCompany(companyId);
    }

    @PutMapping(value = "/update-customer-company/{companyId}")
    public BaseRequestResponse updateCustomerCompany(@PathVariable("companyId") Integer companyId, @RequestBody CustomerCompaniesDTO companiesDTO) {
        if(!companyId.equals(companiesDTO.getIdCompany())) {
            throw new ResourceNotFoundException("The id is not the same with id from object");
        }
        CustomerCompaniesDTO companyDB = customerCompaniesService.getCustomerCompanyById(companyId);
        if(companyDB == null) {
            throw new ResourceNotFoundException("Not found");
        }
        CustomerCompaniesMapper customerCompaniesMapper = new CustomerCompaniesMapper();
        customerCompaniesMapper.mergeEntities(companyDB, companiesDTO);
        return customerCompaniesService.saveCustomerCompany(companyDB);
    }
}
