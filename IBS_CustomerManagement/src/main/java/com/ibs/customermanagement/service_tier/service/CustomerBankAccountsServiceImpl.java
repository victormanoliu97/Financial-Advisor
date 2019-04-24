package com.ibs.customermanagement.service_tier.service;

import com.ibs.customermanagement.data_tier.dao.CustomerBankAccountsDAO;
import com.ibs.customermanagement.data_tier.repository.CustomerBankAccountsRepository;
import com.ibs.customermanagement.service_tier.mapper.CustomerBankAccountsMapper;
import com.ibs.customermanagement.service_tier.model.CustomerBankAccountsDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void saveCustomerBankAccount(CustomerBankAccountsDTO customerBankAccountsModel) {
        if(customerBankAccountsModel != null) {
            customerBankAccountsDAO.save(new CustomerBankAccountsMapper().fromDTOToEntity(customerBankAccountsModel));
        }
    }

    @Override
    public void deleteCustomerBankAccount(Integer accountId) {
        if(accountId != null) {
            customerBankAccountsDAO.deleteByIdAccount(accountId);
        }
    }
}
