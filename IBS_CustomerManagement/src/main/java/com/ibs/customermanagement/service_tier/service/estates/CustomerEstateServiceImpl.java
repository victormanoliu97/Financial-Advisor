package com.ibs.customermanagement.service_tier.service.estates;

import com.ibs.customermanagement.data_tier.dao.CustomerFinancialEstatesDAO;
import com.ibs.customermanagement.data_tier.repository.CustomerFinancialEstatesRepository;
import com.ibs.customermanagement.service_tier.mapper.CustomerEstatesMapper;
import com.ibs.customermanagement.service_tier.model.CustomerEstatesDTO;
import com.ibs.customermanagement.web_tier.response.BaseRequestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerEstateServiceImpl implements CustomerEstatesService {

    private final CustomerFinancialEstatesDAO customerFinancialEstatesDAO;
    private final CustomerFinancialEstatesRepository customerFinancialEstatesRepository;

    @Autowired
    public CustomerEstateServiceImpl(CustomerFinancialEstatesDAO customerFinancialEstatesDAO, CustomerFinancialEstatesRepository customerFinancialEstatesRepository) {
        this.customerFinancialEstatesDAO = customerFinancialEstatesDAO;
        this.customerFinancialEstatesRepository = customerFinancialEstatesRepository;
    }

    @Override
    public List<CustomerEstatesDTO> getCustomerEstates(Integer customerId) {
        if(customerId == null) {
            return null;
        }
        return new CustomerEstatesMapper().fromEntityListToDtoList(customerFinancialEstatesRepository.getAllByCustomerId(customerId));
    }

    @Override
    public BaseRequestResponse saveCustomerEstate(CustomerEstatesDTO estatesDTO) {
        if(estatesDTO == null) {
            return new BaseRequestResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
        }
        customerFinancialEstatesDAO.save(new CustomerEstatesMapper().fromDtoToEntity(estatesDTO));
        return new BaseRequestResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    @Override
    public BaseRequestResponse deleteCustomerEstate(Integer estateId) {
        if(estateId == null) {
            return new BaseRequestResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
        }
        customerFinancialEstatesDAO.deleteByIdEstate(estateId);
        return new BaseRequestResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    @Override
    public BaseRequestResponse updateCustomerEstate(CustomerEstatesDTO estatesDTO) {
        if(estatesDTO == null || estatesDTO.getCustomerId() == 0 || estatesDTO.getIdEstate() == 0) {
            return new BaseRequestResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
        }
        if(customerFinancialEstatesRepository.getAllByCustomerId(estatesDTO.getCustomerId()) == null) {
            return new BaseRequestResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase());
        }
        customerFinancialEstatesDAO.save(new CustomerEstatesMapper().fromDtoToEntity(estatesDTO));
        return new BaseRequestResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    @Override
    public CustomerEstatesDTO getEstateById(Integer estateId) {
        if (estateId == null) {
            return null;
        }
        return new CustomerEstatesMapper().fromEntityToDto(customerFinancialEstatesRepository.getByIdEstate(estateId));
    }

}
