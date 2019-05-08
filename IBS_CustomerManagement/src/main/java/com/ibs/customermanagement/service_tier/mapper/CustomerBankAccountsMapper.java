package com.ibs.customermanagement.service_tier.mapper;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomersBankAccountsEntity;
import com.ibs.customermanagement.service_tier.model.CustomerBankAccountsDTO;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;


public class CustomerBankAccountsMapper {

    public CustomerBankAccountsDTO fromEntityToDTO(TIbsCustomersBankAccountsEntity entity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, CustomerBankAccountsDTO.class);
    }

    public TIbsCustomersBankAccountsEntity fromDTOToEntity(CustomerBankAccountsDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, TIbsCustomersBankAccountsEntity.class);
    }

    public List<CustomerBankAccountsDTO> fromEntityListToDTOList(List<TIbsCustomersBankAccountsEntity> entityList) {
        List<CustomerBankAccountsDTO> modelList = new ArrayList<>();
        for(TIbsCustomersBankAccountsEntity entity : entityList) {
            modelList.add(fromEntityToDTO(entity));
        }
        return modelList;
    }
}
