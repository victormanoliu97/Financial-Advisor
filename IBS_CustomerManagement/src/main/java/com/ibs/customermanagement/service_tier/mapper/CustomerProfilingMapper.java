package com.ibs.customermanagement.service_tier.mapper;

import com.ibs.customermanagement.data_tier.entity.TIbsCustomersProfilingEntity;
import com.ibs.customermanagement.service_tier.model.CustomerProfilingDTO;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class CustomerProfilingMapper {

    public CustomerProfilingDTO fromEntityToDTO(TIbsCustomersProfilingEntity entity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(entity, CustomerProfilingDTO.class);
    }

    public TIbsCustomersProfilingEntity fromDTOToEntity(CustomerProfilingDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, TIbsCustomersProfilingEntity.class);
    }

    public List<CustomerProfilingDTO> fromEntityListToDTOList(List<TIbsCustomersProfilingEntity> entityList) {
        List<CustomerProfilingDTO> dtoList = new ArrayList<>();
        for(TIbsCustomersProfilingEntity entity : entityList) {
            dtoList.add(fromEntityToDTO(entity));
        }
        return dtoList;
    }

    public void mergeEntities(CustomerProfilingDTO profilingDB, CustomerProfilingDTO profilingRequest) {
        profilingDB.setIdCustomer(profilingRequest.getIdCustomer());
        profilingDB.setIdProfiling(profilingRequest.getIdProfiling());
        profilingDB.setProfession(profilingRequest.getProfession());
        profilingDB.setCurrentJob(profilingRequest.getCurrentJob());
        profilingDB.setResidenceCity(profilingRequest.getResidenceCity());
        profilingDB.setResidenceProvince(profilingRequest.getResidenceProvince());
        profilingDB.setBirthCity(profilingRequest.getBirthCity());
        profilingDB.setBirthResidence(profilingRequest.getBirthResidence());
        profilingDB.setGender(profilingRequest.getGender());
        profilingDB.setWorkSegment(profilingRequest.getWorkSegment());
    }
}
