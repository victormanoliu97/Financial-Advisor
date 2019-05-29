package com.ibs.customermanagement.service_tier.service.customer_profiling;

import com.ibs.customermanagement.data_tier.dao.CustomerProfilingDAO;
import com.ibs.customermanagement.data_tier.repository.CustomerProfilingRepository;
import com.ibs.customermanagement.service_tier.mapper.CustomerProfilingMapper;
import com.ibs.customermanagement.service_tier.model.CustomerProfilingDTO;
import com.ibs.customermanagement.service_tier.utils.GeneralUtills;
import com.ibs.customermanagement.web_tier.response.BaseRequestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerProfilingServiceImpl implements CustomerProfilingService  {

    private final CustomerProfilingRepository customerProfilingRepository;
    private final CustomerProfilingDAO customerProfilingDAO;

    private GeneralUtills generalUtills = new GeneralUtills();

    @Autowired
    public CustomerProfilingServiceImpl(CustomerProfilingRepository customerProfilingRepository, CustomerProfilingDAO customerProfilingDAO) {
        this.customerProfilingRepository = customerProfilingRepository;
        this.customerProfilingDAO = customerProfilingDAO;
    }

    @Override
    public List<CustomerProfilingDTO> getCustomerProfiling(Integer customerId) {
        if(customerId == null) {
            return null;
        }
        if(customerProfilingRepository.getAllByIdCustomer(customerId) == null) {
            return null;
        }
        return new CustomerProfilingMapper().fromEntityListToDTOList(customerProfilingRepository.getAllByIdCustomer(customerId));
    }

    @Override
    public BaseRequestResponse saveCustomerProfiling(CustomerProfilingDTO customerProfilingDTO) {
        if(customerProfilingDTO == null) {
            return new BaseRequestResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
        }
        customerProfilingDAO.save(new CustomerProfilingMapper().fromDTOToEntity(customerProfilingDTO));
        return new BaseRequestResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    @Override
    public BaseRequestResponse updateCustomerProfiling(CustomerProfilingDTO customerProfilingDTO) {
        if (customerProfilingDTO == null || customerProfilingDTO.getIdProfiling() == 0 || customerProfilingDTO.getIdCustomer() == 0) {
            return new BaseRequestResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
        }
        customerProfilingDAO.save(new CustomerProfilingMapper().fromDTOToEntity(customerProfilingDTO));
        return new BaseRequestResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    @Override
    public CustomerProfilingDTO getByIdProfiling(Integer idProfiling) {
        return new CustomerProfilingMapper().fromEntityToDTO(customerProfilingRepository.getByIdProfiling(idProfiling));
    }
}
