package com.ibs.customermanagement.service_tier.service.objectives;

import com.ibs.customermanagement.data_tier.dao.CustomerFinancialObjectivesDAO;
import com.ibs.customermanagement.data_tier.entity.TIbsCustomersCustomerFinancialEstatesEntity;
import com.ibs.customermanagement.data_tier.entity.TIbsCustomersCustomerFinancialIncomeEntity;
import com.ibs.customermanagement.data_tier.entity.TIbsCustomersCustomerFinancialLiabilitiesEntity;
import com.ibs.customermanagement.data_tier.repository.CustomerFinancialEstatesRepository;
import com.ibs.customermanagement.data_tier.repository.CustomerFinancialIncomeRepository;
import com.ibs.customermanagement.data_tier.repository.CustomerFinancialLiabilitiesRepository;
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
    private final CustomerFinancialIncomeRepository customerFinancialIncomeRepository;
    private final CustomerFinancialLiabilitiesRepository customerFinancialLiabilitiesRepository;
    private final CustomerFinancialEstatesRepository customerFinancialEstatesRepository;

    private RequestSender requestSender = new RequestSender();

    @Autowired
    public CustomerFinancialObjectiveServiceImpl(CustomerFinancialObjectivesRepository customerFinancialObjectivesRepository, CustomerFinancialObjectivesDAO customerFinancialObjectivesDAO, CustomerFinancialIncomeRepository customerFinancialIncomeRepository, CustomerFinancialLiabilitiesRepository customerFinancialLiabilitiesRepository, CustomerFinancialEstatesRepository customerFinancialEstatesRepository) {
        this.customerFinancialObjectivesRepository = customerFinancialObjectivesRepository;
        this.customerFinancialObjectivesDAO = customerFinancialObjectivesDAO;
        this.customerFinancialIncomeRepository = customerFinancialIncomeRepository;
        this.customerFinancialLiabilitiesRepository = customerFinancialLiabilitiesRepository;
        this.customerFinancialEstatesRepository = customerFinancialEstatesRepository;
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
        Double customerIncomeAmount = customerFinancialIncomeRepository.getAllByCustomerId(objectiveDTO.getCustomerId()).stream().mapToDouble(TIbsCustomersCustomerFinancialIncomeEntity::getIncomeAmount).sum();
        Double compressibleCosts = customerFinancialIncomeRepository.getAllByCustomerId(objectiveDTO.getCustomerId()).stream().mapToDouble(TIbsCustomersCustomerFinancialIncomeEntity::getCompressibleCosts).sum();
        Double nonCompressibleCosts = customerFinancialIncomeRepository.getAllByCustomerId(objectiveDTO.getCustomerId()).stream().mapToDouble(TIbsCustomersCustomerFinancialIncomeEntity::getNonCompressibleCosts).sum();
        Double customerLiabilitiesAmount = customerFinancialLiabilitiesRepository.getAllByCustomerId(objectiveDTO.getCustomerId()).stream().mapToDouble(TIbsCustomersCustomerFinancialLiabilitiesEntity::getLiabilitiesAmount).sum();
        Double customerEstatesRevenueAmount = customerFinancialEstatesRepository.getAllByCustomerId(objectiveDTO.getCustomerId()).stream().mapToDouble(TIbsCustomersCustomerFinancialEstatesEntity::getEstateValue).sum();

        double finalAmount = (customerIncomeAmount + customerEstatesRevenueAmount) - (compressibleCosts + nonCompressibleCosts + customerLiabilitiesAmount);
        objectiveDTO.setIncome(finalAmount);

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
