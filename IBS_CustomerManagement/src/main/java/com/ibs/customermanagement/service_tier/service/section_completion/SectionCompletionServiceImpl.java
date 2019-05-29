package com.ibs.customermanagement.service_tier.service.section_completion;

import com.ibs.customermanagement.data_tier.repository.CustomerFinancialCompaniesRepository;
import com.ibs.customermanagement.data_tier.repository.CustomerFinancialEstatesRepository;
import com.ibs.customermanagement.data_tier.repository.CustomerFinancialIncomeRepository;
import com.ibs.customermanagement.service_tier.model.SectionCompletionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SectionCompletionServiceImpl implements SectionCompletionService  {

    private final CustomerFinancialIncomeRepository incomeRepository;
    private final CustomerFinancialEstatesRepository estatesRepository;
    private final CustomerFinancialCompaniesRepository companiesRepository;

    @Autowired
    public SectionCompletionServiceImpl(CustomerFinancialIncomeRepository incomeRepository, CustomerFinancialEstatesRepository estatesRepository, CustomerFinancialCompaniesRepository companiesRepository) {
        this.incomeRepository = incomeRepository;
        this.estatesRepository = estatesRepository;
        this.companiesRepository = companiesRepository;
    }


    @Override
    public SectionCompletionDTO returnCustomerSectionCompletion(Integer customerId) {
        SectionCompletionDTO sectionCompletionDTO = new SectionCompletionDTO();
        if(incomeRepository.getAllByCustomerId(customerId).equals(Collections.emptyList())) {
            sectionCompletionDTO.setIncomeCompletion(0);
        }
        else {
            sectionCompletionDTO.setIncomeCompletion(100);
        }
        if(estatesRepository.getAllByCustomerId(customerId).equals(Collections.emptyList())) {
            sectionCompletionDTO.setEstatesCompletion(0);
        }
        else {
            sectionCompletionDTO.setEstatesCompletion(100);
        }
        if(companiesRepository.getAllByCustomerId(customerId).equals(Collections.emptyList())) {
            sectionCompletionDTO.setCompaniesCompletion(0);
        }
        else {
            sectionCompletionDTO.setCompaniesCompletion(100);
        }
        return sectionCompletionDTO;
    }
}
