package com.ibs.customermanagement.service_tier.mapper;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomersCustomerFinancialIncomeEntity;
import com.ibs.customermanagement.service_tier.model.CustomerFinancialIncomeDTO;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class CustomerFinancialIncomeMapper {

    public CustomerFinancialIncomeDTO fromEntityToDTO(TIbsCustomersCustomerFinancialIncomeEntity entity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, CustomerFinancialIncomeDTO.class);
    }

    public TIbsCustomersCustomerFinancialIncomeEntity fromDTOToEntity(CustomerFinancialIncomeDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, TIbsCustomersCustomerFinancialIncomeEntity.class);
    }

    public void mergeEntities(CustomerFinancialIncomeDTO incomeDB, CustomerFinancialIncomeDTO incomeRequest) {
        incomeDB.setIdFinancialIncome(incomeRequest.getIdFinancialIncome());
        incomeDB.setCustomerId(incomeRequest.getCustomerId());
        incomeDB.setIncomeAmount(incomeRequest.getIncomeAmount());
        incomeDB.setIncomeSource(incomeRequest.getIncomeSource());
        incomeDB.setCompressibleCosts(incomeRequest.getCompressibleCosts());
        incomeDB.setNonCompressibleCosts(incomeRequest.getNonCompressibleCosts());
    }

    public List<CustomerFinancialIncomeDTO> fromEntityListToDtoList(List<TIbsCustomersCustomerFinancialIncomeEntity> entityList) {
        List<CustomerFinancialIncomeDTO> dtoList = new ArrayList<>();
        for(TIbsCustomersCustomerFinancialIncomeEntity entity : entityList) {
            dtoList.add(fromEntityToDTO(entity));
        }
        return dtoList;
    }
}
