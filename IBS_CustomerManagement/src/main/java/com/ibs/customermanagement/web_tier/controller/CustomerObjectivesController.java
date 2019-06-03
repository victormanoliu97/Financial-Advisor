package com.ibs.customermanagement.web_tier.controller;

import com.ibs.customermanagement.service_tier.model.CustomerFinancialObjectiveRequestDTO;
import com.ibs.customermanagement.service_tier.model.CustomerFinancialObjectiveResponseDTO;
import com.ibs.customermanagement.service_tier.service.objectives.CustomerFinancialObjectivesService;
import com.ibs.customermanagement.web_tier.handlers.http_exceptions.UnprocessableEntityException;
import com.ibs.customermanagement.web_tier.response.BaseRequestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerObjectivesController {

    private final CustomerFinancialObjectivesService customerFinancialObjectivesService;

    @Autowired
    public CustomerObjectivesController(CustomerFinancialObjectivesService customerFinancialObjectivesService) {
        this.customerFinancialObjectivesService = customerFinancialObjectivesService;
    }

    @GetMapping(value = "/get-customer-objectives/{customerId}")
    public List<CustomerFinancialObjectiveResponseDTO> getCustomerObjectives(@PathVariable Integer customerId) {
        if(customerId == null) {
            throw new UnprocessableEntityException("The requested parameter is null");
        }
        return customerFinancialObjectivesService.getCustomerObjectives(customerId);
    }

    @PostMapping(value = "/create-customer-objective")
    public BaseRequestResponse saveCustomerObjective(@RequestBody CustomerFinancialObjectiveRequestDTO objectiveRequestDTO) {
        return customerFinancialObjectivesService.saveCustomerObjective(objectiveRequestDTO);
    }

    @DeleteMapping(value = "/delete-customer-objective/{id}")
    public BaseRequestResponse deleteCustomerObjective(@PathVariable Integer id) {
        if(id == null) {
            return new BaseRequestResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return customerFinancialObjectivesService.deleteCustomerObjective(id);
    }
}
