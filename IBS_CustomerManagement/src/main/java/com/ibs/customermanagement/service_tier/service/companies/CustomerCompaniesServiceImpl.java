package com.ibs.customermanagement.service_tier.service.companies;

import com.ibs.customermanagement.data_tier.dao.CustomerFinancialCompaniesDAO;
import com.ibs.customermanagement.data_tier.repository.CustomerFinancialCompaniesRepository;
import com.ibs.customermanagement.service_tier.mapper.CustomerCompaniesMapper;
import com.ibs.customermanagement.service_tier.model.CustomerCompaniesDTO;
import com.ibs.customermanagement.web_tier.response.BaseRequestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CustomerCompaniesServiceImpl implements CustomerCompaniesService {

    private final CustomerFinancialCompaniesDAO customerFinancialCompaniesDAO;
    private final CustomerFinancialCompaniesRepository companiesRepository;

    @Autowired
    public CustomerCompaniesServiceImpl(CustomerFinancialCompaniesDAO customerFinancialCompaniesDAO, CustomerFinancialCompaniesRepository companiesRepository) {
        this.customerFinancialCompaniesDAO = customerFinancialCompaniesDAO;
        this.companiesRepository = companiesRepository;
    }


    @Override
    public List<CustomerCompaniesDTO> getCustomerCompanies(Integer customerId) {
        if(customerId == null) {
            return Collections.emptyList();
        }
        return new CustomerCompaniesMapper().fromEntityListToDtoList(companiesRepository.getAllByCustomerId(customerId));
    }

    @Override
    public BaseRequestResponse saveCustomerCompany(CustomerCompaniesDTO companiesDTO) {
        if(companiesDTO == null) {
            return new BaseRequestResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
        }
        customerFinancialCompaniesDAO.save(new CustomerCompaniesMapper().fromDtoToEntity(companiesDTO));
        return new BaseRequestResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    @Override
    public BaseRequestResponse deleteCustomerCompany(Integer companyId) {
        if(companyId == null) {
            return new BaseRequestResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
        }
        customerFinancialCompaniesDAO.deleteByIdCompany(companyId);
        return new BaseRequestResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    @Override
    public BaseRequestResponse updateCustomerCompany(CustomerCompaniesDTO companiesDTO) {
        if(companiesDTO == null || companiesDTO.getCustomerId() == 0 || companiesDTO.getIdCompany() == 0) {
            return new BaseRequestResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
        }
        if(companiesRepository.getByIdCompany(companiesDTO.getIdCompany()) == null) {
           return new BaseRequestResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase());
        }
        customerFinancialCompaniesDAO.save(new CustomerCompaniesMapper().fromDtoToEntity(companiesDTO));
        return new BaseRequestResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }

    @Override
    public CustomerCompaniesDTO getCustomerCompanyById(Integer companyId) {
        if(companyId == null) {
            return null;
        }
        return new CustomerCompaniesMapper().fromEntityToDTO(companiesRepository.getByIdCompany(companyId));
    }
}
