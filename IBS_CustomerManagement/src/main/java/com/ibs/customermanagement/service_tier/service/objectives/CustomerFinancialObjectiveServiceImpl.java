package com.ibs.customermanagement.service_tier.service.objectives;

import com.ibs.customermanagement.data_tier.dao.CustomerFinancialObjectivesDAO;
import com.ibs.customermanagement.data_tier.repository.CustomerFinancialObjectivesRepository;
import com.ibs.customermanagement.service_tier.mapper.CustomerFinancialObjectiveMapper;
import com.ibs.customermanagement.service_tier.model.CustomerFinancialObjectiveRequestDTO;
import com.ibs.customermanagement.service_tier.model.CustomerFinancialObjectiveResponseDTO;
import com.ibs.customermanagement.service_tier.utils.RequestSender;
import com.ibs.customermanagement.web_tier.response.BaseRequestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CustomerFinancialObjectiveServiceImpl implements CustomerFinancialObjectivesService {

    private final CustomerFinancialObjectivesRepository customerFinancialObjectivesRepository;
    private final CustomerFinancialObjectivesDAO customerFinancialObjectivesDAO;

    private RequestSender requestSender = new RequestSender();

    @Autowired
    public CustomerFinancialObjectiveServiceImpl(CustomerFinancialObjectivesRepository customerFinancialObjectivesRepository, CustomerFinancialObjectivesDAO customerFinancialObjectivesDAO) {
        this.customerFinancialObjectivesRepository = customerFinancialObjectivesRepository;
        this.customerFinancialObjectivesDAO = customerFinancialObjectivesDAO;
    }

    @Override
    public List<CustomerFinancialObjectiveResponseDTO> getCustomerObjectives(Integer customerId) {
        if(customerId == null) {
            return Collections.emptyList();
        }
        return new CustomerFinancialObjectiveMapper().fromEntityResponseListToDtoList(customerFinancialObjectivesRepository.getAllByCustomerId(customerId));
    }

    @Override
    public BaseRequestResponse saveCustomerObjective(CustomerFinancialObjectiveRequestDTO objectiveDTO) {
        if(objectiveDTO == null) {
            return new BaseRequestResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
        }
        requestSender.sendObjectiveRequest(objectiveDTO.toString());
        return new BaseRequestResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    @Override
    public BaseRequestResponse deleteCustomerObjective(Integer id) {
        if(id == null) {
            return new BaseRequestResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
        }
        customerFinancialObjectivesDAO.deleteById(id);
        return new BaseRequestResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    @Override
    public BaseRequestResponse updateCustomerObjective(CustomerFinancialObjectiveRequestDTO objectiveDTO) {
        if(objectiveDTO == null || objectiveDTO.getCustomerId() == 0 || objectiveDTO.getId() == 0) {
            return new BaseRequestResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
        }
        customerFinancialObjectivesDAO.save(new CustomerFinancialObjectiveMapper().fromDtoRequestToEntity(objectiveDTO));
        return new BaseRequestResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    @Override
    public CustomerFinancialObjectiveResponseDTO getObjectiveById(Integer id) {
        if(id == null) {
            return null;
        }
        return new CustomerFinancialObjectiveMapper().fromEntityResponseToDto(customerFinancialObjectivesRepository.getById(id));
    }
}
