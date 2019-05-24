package com.ibs.customermanagement.service_tier.service.liabilities;

import com.ibs.customermanagement.data_tier.dao.CustomerFinancialLiabilitiesDAO;
import com.ibs.customermanagement.data_tier.repository.CustomerFinancialLiabilitiesRepository;
import com.ibs.customermanagement.service_tier.mapper.CustomerFinancialLiabilitiesMapper;
import com.ibs.customermanagement.service_tier.model.CustomerFinancialLiabilitiesDTO;
import com.ibs.customermanagement.web_tier.response.BaseRequestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerFinancialLiabilitiesServiceImpl implements CustomerFinancialLiabilitiesService {

    private final CustomerFinancialLiabilitiesDAO customerFinancialLiabilitiesDAO;
    private CustomerFinancialLiabilitiesRepository customerFinancialLiabilitiesRepository;

    @Autowired
    public CustomerFinancialLiabilitiesServiceImpl(CustomerFinancialLiabilitiesDAO customerFinancialLiabilitiesDAO, CustomerFinancialLiabilitiesRepository customerFinancialLiabilitiesRepository ) {
        this.customerFinancialLiabilitiesDAO = customerFinancialLiabilitiesDAO;
        this.customerFinancialLiabilitiesRepository = customerFinancialLiabilitiesRepository;
    }

    @Override
    public List<CustomerFinancialLiabilitiesDTO> getCustomerFinancialLiabilities(Integer customerId) {
        if(customerId == null) {
            return null;
        }
        return new CustomerFinancialLiabilitiesMapper().fromEntityListToDtoList(customerFinancialLiabilitiesRepository.getAllByCustomerId(customerId));
    }

    @Override
    public BaseRequestResponse saveCustomerFinancialLiability(CustomerFinancialLiabilitiesDTO customerFinancialLiabilitiesDTO) {
        if(customerFinancialLiabilitiesDTO == null) {
            return new BaseRequestResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
        }
        customerFinancialLiabilitiesDAO.save(new CustomerFinancialLiabilitiesMapper().fromDTOToEntity(customerFinancialLiabilitiesDTO));
        return new BaseRequestResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    @Override
    public BaseRequestResponse deleteCustomerFinancialLiability(Integer liabilityId) {
        if(liabilityId == null) {
            return new BaseRequestResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
        }
        customerFinancialLiabilitiesDAO.deleteByIdFinancialLiability(liabilityId);
        return new BaseRequestResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    @Override
    public BaseRequestResponse updateCustomerFinancialLiability(CustomerFinancialLiabilitiesDTO customerFinancialLiabilitiesDTO) {
        if(customerFinancialLiabilitiesDTO == null || customerFinancialLiabilitiesDTO.getCustomerId() == 0 || customerFinancialLiabilitiesDTO.getIdFinancialLiability() == 0) {
            return new BaseRequestResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
        }
        customerFinancialLiabilitiesDAO.save(new CustomerFinancialLiabilitiesMapper().fromDTOToEntity(customerFinancialLiabilitiesDTO));
        return new BaseRequestResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    @Override
    public CustomerFinancialLiabilitiesDTO getLiabilityById(Integer liabilityId) {
        if(liabilityId == null) {
            return null;
        }
        return new CustomerFinancialLiabilitiesMapper().fromEntityToDTO(customerFinancialLiabilitiesRepository.getByIdFinancialLiability(liabilityId));
    }
}
