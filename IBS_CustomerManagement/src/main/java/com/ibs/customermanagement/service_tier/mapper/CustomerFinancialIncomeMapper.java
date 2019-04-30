package com.ibs.customermanagement.service_tier.mapper;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomersCustomerFinancialIncomeEntity;
import com.ibs.customermanagement.service_tier.model.CustomerFinancialIncomeDTO;

import java.util.ArrayList;
import java.util.List;

public class CustomerFinancialIncomeMapper {

    public CustomerFinancialIncomeDTO fromEntityToDTO(TIbsCustomersCustomerFinancialIncomeEntity entity) {
        CustomerFinancialIncomeDTO dto = new CustomerFinancialIncomeDTO();
        dto.setIdFinancialIncome(entity.getIdFinancialIncome());
        dto.setCustomerId(entity.getCustomerId());
        dto.setCompressibleCosts(entity.getCompressibleCosts());
        dto.setIncomeAmount(entity.getIncomeAmount());
        dto.setIncomeSource(entity.getIncomeSource());
        dto.setNonCompressibleCosts(entity.getNonCompressibleCosts());
        return dto;
    }

    public TIbsCustomersCustomerFinancialIncomeEntity fromDTOToEntity(CustomerFinancialIncomeDTO dto) {
        TIbsCustomersCustomerFinancialIncomeEntity entity = new TIbsCustomersCustomerFinancialIncomeEntity();
        entity.setIdFinancialIncome(dto.getIdFinancialIncome());
        entity.setCustomerId(dto.getCustomerId());
        entity.setCompressibleCosts(dto.getCompressibleCosts());
        entity.setNonCompressibleCosts(dto.getNonCompressibleCosts());
        entity.setIncomeAmount(dto.getIncomeAmount());
        entity.setIncomeSource(dto.getIncomeSource());
        return entity;
    }

    public List<CustomerFinancialIncomeDTO> fromEntityListToDtoList(List<TIbsCustomersCustomerFinancialIncomeEntity> entityList) {
        List<CustomerFinancialIncomeDTO> dtoList = new ArrayList<>();
        for(TIbsCustomersCustomerFinancialIncomeEntity entity : entityList) {
            dtoList.add(fromEntityToDTO(entity));
        }
        return dtoList;
    }
}
