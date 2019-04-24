package com.ibs.customermanagement.service_tier.mapper;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomersBankAccountsEntity;
import com.ibs.customermanagement.service_tier.model.CustomerBankAccountsDTO;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
public class CustomerBankAccountsMapper {

    public CustomerBankAccountsDTO fromEntityToDTO(TIbsCustomersBankAccountsEntity entity) {
        CustomerBankAccountsDTO model = new CustomerBankAccountsDTO();
        model.setIdAccount(entity.getIdAccount());
        model.setAccountType(entity.getAccountType());
        model.setBankId(entity.getBankId());
        model.setCurrentSold(entity.getCurrentSold());
        model.setCustomerId(entity.getCustomerId());
        model.setIban(entity.getIban());
        model.setLoanAmount(entity.getLoanAmount());
        model.setStatus(entity.getStatus());
        return model;
    }

    public TIbsCustomersBankAccountsEntity fromDTOToEntity(CustomerBankAccountsDTO model) {
        TIbsCustomersBankAccountsEntity entity = new TIbsCustomersBankAccountsEntity();
        entity.setIdAccount(model.getIdAccount());
        entity.setAccountType(model.getAccountType());
        entity.setBankId(model.getBankId());
        entity.setCurrentSold(model.getCurrentSold());
        entity.setCustomerId(model.getCustomerId());
        entity.setIban(model.getIban());
        entity.setLoanAmount(model.getLoanAmount());
        entity.setStatus(model.getStatus());
        return entity;
    }

    public List<CustomerBankAccountsDTO> fromEntityListToDTOList(List<TIbsCustomersBankAccountsEntity> entityList) {
        List<CustomerBankAccountsDTO> modelList = new ArrayList<>();
        for(TIbsCustomersBankAccountsEntity entity : entityList) {
            modelList.add(fromEntityToDTO(entity));
        }
        return modelList;
    }
}
