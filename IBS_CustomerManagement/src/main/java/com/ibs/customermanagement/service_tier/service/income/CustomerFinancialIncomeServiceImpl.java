package com.ibs.customermanagement.service_tier.service.income;

import com.ibs.customermanagement.data_tier.dao.CustomerFinancialIncomeDAO;
import com.ibs.customermanagement.data_tier.repository.CustomerFinancialIncomeRepository;
import com.ibs.customermanagement.service_tier.mapper.CustomerFinancialIncomeMapper;
import com.ibs.customermanagement.service_tier.model.CustomerFinancialIncomeDTO;
import com.ibs.customermanagement.web_tier.response.BaseRequestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerFinancialIncomeServiceImpl implements CustomerFinancialIncomeService {

    private final CustomerFinancialIncomeDAO customerFinancialIncomeDAO;
    private CustomerFinancialIncomeRepository customerFinancialIncomeRepository;

    @Autowired
    public CustomerFinancialIncomeServiceImpl(CustomerFinancialIncomeDAO customerFinancialIncomeDAO) {
        this.customerFinancialIncomeDAO = customerFinancialIncomeDAO;
    }

    @Override
    public List<CustomerFinancialIncomeDTO> getCustomerFinancialIncomes(Integer customerId) {
        if (customerId == null) {
            return null;
        }
        return new CustomerFinancialIncomeMapper().fromEntityListToDtoList(
                customerFinancialIncomeRepository.getAllByCustomerId(customerId));
    }

    @Override
    public BaseRequestResponse saveCustomerFinancialIncomeEntry(CustomerFinancialIncomeDTO customerFinancialIncomeDTO) {
        if (customerFinancialIncomeDTO == null) {
            return new BaseRequestResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
        }
        customerFinancialIncomeDAO.save(new CustomerFinancialIncomeMapper().fromDTOToEntity(customerFinancialIncomeDTO));
        return new BaseRequestResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    @Override
    public BaseRequestResponse deleteCustomerFinancialIncomeEntity(Integer incomeId) {
        if (incomeId == null) {
            return new BaseRequestResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
        }
        customerFinancialIncomeDAO.deleteByIdFinancialIncome(incomeId);
        return new BaseRequestResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }
}
