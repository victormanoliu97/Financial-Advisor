package com.ibs.customermanagement.service_tier.service;

import com.ibs.customermanagement.data_tier.dao.CustomerBankAccountsDAO;
import com.ibs.customermanagement.data_tier.repository.CustomerBankAccountsRepository;
import com.ibs.customermanagement.service_tier.constants.GeneralConstants;
import com.ibs.customermanagement.service_tier.mapper.CustomerBankAccountsMapper;
import com.ibs.customermanagement.service_tier.model.CustomerBankAccountsDTO;
import com.ibs.customermanagement.web_tier.response.BaseRequestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerBankAccountsServiceImpl implements CustomerBankAccountsService {

    private final CustomerBankAccountsRepository customerBankAccountsRepository;
    private final CustomerBankAccountsDAO customerBankAccountsDAO;

    @Autowired
    public CustomerBankAccountsServiceImpl(CustomerBankAccountsRepository customerBankAccountsRepository, CustomerBankAccountsDAO customerBankAccountsDAO) {
        this.customerBankAccountsRepository = customerBankAccountsRepository;
        this.customerBankAccountsDAO = customerBankAccountsDAO;
    }

    @Override
    public List<CustomerBankAccountsDTO> getCustomerBankAccounts(Integer customerId) {
        if(customerId == null) {
            return null;
        }
        return new CustomerBankAccountsMapper().fromEntityListToDTOList(customerBankAccountsRepository.getAllByCustomerId(customerId));
    }

    @Override
    public BaseRequestResponse saveCustomerBankAccount(CustomerBankAccountsDTO customerBankAccountsModel) {
        if(customerBankAccountsModel == null) {
            return new BaseRequestResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
        }
        customerBankAccountsModel.setStatus(GeneralConstants.CREATED_ACCOUNT.getStatus());
        customerBankAccountsDAO.save(new CustomerBankAccountsMapper().fromDTOToEntity(customerBankAccountsModel));
        return new BaseRequestResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    @Override
    public BaseRequestResponse deleteCustomerBankAccount(Integer accountId) {
        if(accountId == null) {
            return new BaseRequestResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
        }
        customerBankAccountsDAO.updateCustomerAccountStatus(GeneralConstants.CLOSED_ACCOUNT.getStatus(), accountId);
        return new BaseRequestResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }
}
