package com.ibs.customermanagement.web_tier.controller;

import com.ibs.customermanagement.service_tier.mapper.CustomerFinancialIncomeMapper;
import com.ibs.customermanagement.service_tier.model.CustomerFinancialIncomeDTO;
import com.ibs.customermanagement.service_tier.service.income.CustomerFinancialIncomeService;
import com.ibs.customermanagement.web_tier.handlers.http_exceptions.ResourceNotFoundException;
import com.ibs.customermanagement.web_tier.handlers.http_exceptions.UnprocessableEntityException;
import com.ibs.customermanagement.web_tier.response.BaseRequestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerIncomeController {

    private final CustomerFinancialIncomeService customerFinancialIncomeService;

    @Autowired
    public CustomerIncomeController(CustomerFinancialIncomeService customerFinancialIncomeService) {
        this.customerFinancialIncomeService = customerFinancialIncomeService;
    }

    @GetMapping(value = "/get-customer-incomes/{customerId}")
    public List<CustomerFinancialIncomeDTO> getCustomerIncomes(@PathVariable Integer customerId) {
        if(customerId == null) {
            throw new UnprocessableEntityException("The requested parameter is null");
        }
        return customerFinancialIncomeService.getCustomerFinancialIncomes(customerId);
    }

    @PostMapping(value = "/create-customer-income")
    public BaseRequestResponse saveCustomerIncome(@RequestBody CustomerFinancialIncomeDTO customerFinancialIncomeDTO) {
        return customerFinancialIncomeService.saveCustomerFinancialIncomeEntry(customerFinancialIncomeDTO);
    }

    @PutMapping(value = "/update-customer-income/{incomeID}")
    public BaseRequestResponse updateCustomerIncome(@PathVariable("incomeID") Integer incomeId, @RequestBody CustomerFinancialIncomeDTO customerFinancialIncomeDTO) {
        if(!incomeId.equals(customerFinancialIncomeDTO.getIdFinancialIncome())) {
            throw new ResourceNotFoundException("The id is not the same with id from object");
        }
        CustomerFinancialIncomeDTO incomeDB = customerFinancialIncomeService.getCustomerFinancialIncomes(incomeId).get(0);
        if(incomeDB == null) {
            throw new ResourceNotFoundException("Not found");
        }
        CustomerFinancialIncomeMapper customerFinancialIncomeMapper = new CustomerFinancialIncomeMapper();
        customerFinancialIncomeMapper.mergeEntities(incomeDB, customerFinancialIncomeDTO);
        return customerFinancialIncomeService.saveCustomerFinancialIncomeEntry(incomeDB);
    }

    @DeleteMapping(value = "/delete-customer-income/{incomeId}")
    public BaseRequestResponse deleteCustomerIncome(@PathVariable Integer incomeId) {
        if(incomeId == null) {
            throw new UnprocessableEntityException("The requested account id cannot be null");
        }
        return customerFinancialIncomeService.deleteCustomerFinancialIncomeEntity(incomeId);
    }

}
