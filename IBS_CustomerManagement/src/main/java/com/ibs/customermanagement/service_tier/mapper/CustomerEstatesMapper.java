package com.ibs.customermanagement.service_tier.mapper;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomersCustomerFinancialEstatesEntity;
import com.ibs.customermanagement.service_tier.model.CustomerEstatesDTO;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class CustomerEstatesMapper {

    public CustomerEstatesDTO fromEntityToDto(TIbsCustomersCustomerFinancialEstatesEntity entity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, CustomerEstatesDTO.class);
    }

    public TIbsCustomersCustomerFinancialEstatesEntity fromDtoToEntity(CustomerEstatesDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, TIbsCustomersCustomerFinancialEstatesEntity.class);
    }

    public void mergeEntities(CustomerEstatesDTO estateDb, CustomerEstatesDTO estateRequest) {
        estateDb.setCustomerId(estateRequest.getCustomerId());
        estateDb.setIdEstate(estateRequest.getIdEstate());
        estateDb.setEstateName(estateRequest.getEstateName());
        estateDb.setEstateDescription(estateRequest.getEstateDescription());
        estateDb.setEstateType(estateRequest.getEstateType());
        estateDb.setEstateValue(estateRequest.getEstateValue());
    }

    public List<CustomerEstatesDTO> fromEntityListToDtoList(List<TIbsCustomersCustomerFinancialEstatesEntity> entityList) {
        List<CustomerEstatesDTO> dtoList = new ArrayList<>();
        for(TIbsCustomersCustomerFinancialEstatesEntity entity : entityList) {
            dtoList.add(fromEntityToDto(entity));
        }
        return dtoList;
    }
}
