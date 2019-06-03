package com.ibs.customermanagement.service_tier.mapper;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomerFinancialObjectivesEntity;
import com.ibs.customermanagement.service_tier.model.CustomerFinancialObjectiveRequestDTO;
import com.ibs.customermanagement.service_tier.model.CustomerFinancialObjectiveResponseDTO;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class CustomerFinancialObjectiveMapper {

    public CustomerFinancialObjectiveResponseDTO fromEntityResponseToDto(TIbsCustomerFinancialObjectivesEntity entity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, CustomerFinancialObjectiveResponseDTO.class);
    }

    public CustomerFinancialObjectiveRequestDTO fromEntityRequestToDto(TIbsCustomerFinancialObjectivesEntity entity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, CustomerFinancialObjectiveRequestDTO.class);
    }


    public TIbsCustomerFinancialObjectivesEntity fromDtoResponseToEntity(CustomerFinancialObjectiveResponseDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, TIbsCustomerFinancialObjectivesEntity.class);
    }

    public TIbsCustomerFinancialObjectivesEntity fromDtoRequestToEntity(CustomerFinancialObjectiveRequestDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, TIbsCustomerFinancialObjectivesEntity.class);
    }


    public void mergeResponseEntities(CustomerFinancialObjectiveResponseDTO objectiveDb, CustomerFinancialObjectiveResponseDTO objectiveRequest) {
        objectiveDb.setId(objectiveRequest.getId());
        objectiveDb.setCustomerId(objectiveRequest.getCustomerId());
        objectiveDb.setIncome(objectiveRequest.getIncome());
        objectiveDb.setObjectiveValue(objectiveRequest.getObjectiveValue());
        objectiveDb.setYears(objectiveRequest.getYears());
        objectiveDb.setPossible(objectiveRequest.getPossible());
    }

    public void mergeRequestEntities(CustomerFinancialObjectiveRequestDTO objectiveDb, CustomerFinancialObjectiveRequestDTO objectiveRequest) {
        objectiveDb.setId(objectiveRequest.getId());
        objectiveDb.setCustomerId(objectiveRequest.getCustomerId());
        objectiveDb.setIncome(objectiveRequest.getIncome());
        objectiveDb.setObjectiveValue(objectiveRequest.getObjectiveValue());
        objectiveDb.setYears(objectiveRequest.getYears());
    }

    public List<CustomerFinancialObjectiveResponseDTO> fromEntityResponseListToDtoList(List<TIbsCustomerFinancialObjectivesEntity> entityList) {
        List<CustomerFinancialObjectiveResponseDTO> dtoList = new ArrayList<>();
        for (TIbsCustomerFinancialObjectivesEntity entity: entityList) {
            dtoList.add(fromEntityResponseToDto(entity));
        }
        return dtoList;
    }

    public List<CustomerFinancialObjectiveRequestDTO> fromEntityRequestListToDtoList(List<TIbsCustomerFinancialObjectivesEntity> entityList) {
        List<CustomerFinancialObjectiveRequestDTO> dtoList = new ArrayList<>();
        for (TIbsCustomerFinancialObjectivesEntity entity: entityList) {
            dtoList.add(fromEntityRequestToDto(entity));
        }
        return dtoList;
    }
}
