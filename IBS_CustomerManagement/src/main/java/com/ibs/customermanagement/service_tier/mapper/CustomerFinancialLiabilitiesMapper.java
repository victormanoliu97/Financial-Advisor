package com.ibs.customermanagement.service_tier.mapper;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomersCustomerFinancialLiabilitiesEntity;
import com.ibs.customermanagement.service_tier.model.CustomerFinancialLiabilitiesDTO;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class CustomerFinancialLiabilitiesMapper {

    public CustomerFinancialLiabilitiesDTO fromEntityToDTO(TIbsCustomersCustomerFinancialLiabilitiesEntity entity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, CustomerFinancialLiabilitiesDTO.class);
    }

    public TIbsCustomersCustomerFinancialLiabilitiesEntity fromDTOToEntity(CustomerFinancialLiabilitiesDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, TIbsCustomersCustomerFinancialLiabilitiesEntity.class);
    }

    public void mergeEntities(CustomerFinancialLiabilitiesDTO liabilityDB, CustomerFinancialLiabilitiesDTO liabilityRequest) {
        liabilityDB.setIdFinancialLiability(liabilityRequest.getIdFinancialLiability());
        liabilityDB.setCustomerId(liabilityRequest.getCustomerId());
        liabilityDB.setLiabilitiesAmount(liabilityRequest.getLiabilitiesAmount());
        liabilityDB.setLiabilitiesSource(liabilityRequest.getLiabilitiesSource());
    }

    public List<CustomerFinancialLiabilitiesDTO> fromEntityListToDtoList(List<TIbsCustomersCustomerFinancialLiabilitiesEntity> entityList) {
        List<CustomerFinancialLiabilitiesDTO> dtoList = new ArrayList<>();
        for(TIbsCustomersCustomerFinancialLiabilitiesEntity entity : entityList) {
            dtoList.add(fromEntityToDTO(entity));
        }
        return dtoList;
    }
}
