package com.ibs.customermanagement.service_tier.mapper;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomersCustomerFinancialCompaniesEntity;
import com.ibs.customermanagement.service_tier.model.CustomerCompaniesDTO;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class CustomerCompaniesMapper {

    public CustomerCompaniesDTO fromEntityToDTO(TIbsCustomersCustomerFinancialCompaniesEntity entity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, CustomerCompaniesDTO.class);
    }

    public TIbsCustomersCustomerFinancialCompaniesEntity fromDtoToEntity(CustomerCompaniesDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, TIbsCustomersCustomerFinancialCompaniesEntity.class);
    }

    public void mergeEntities(CustomerCompaniesDTO companyDb, CustomerCompaniesDTO companyRequest) {
        companyDb.setIdCompany(companyRequest.getIdCompany());
        companyDb.setCustomerId(companyRequest.getCustomerId());
        companyDb.setCompanyName(companyRequest.getCompanyName());
        companyDb.setCompanyDescription(companyRequest.getCompanyDescription());
        companyDb.setCompanyType(companyRequest.getCompanyType());
        companyDb.setCompanyRevenue(companyRequest.getCompanyRevenue());
    }

    public List<CustomerCompaniesDTO> fromEntityListToDtoList(List<TIbsCustomersCustomerFinancialCompaniesEntity> entityList) {
        List<CustomerCompaniesDTO> dtoList = new ArrayList<>();
        for(TIbsCustomersCustomerFinancialCompaniesEntity entity : entityList) {
            dtoList.add(fromEntityToDTO(entity));
        }
        return dtoList;
    }
}
