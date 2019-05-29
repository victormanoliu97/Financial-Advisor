package com.ibs.customermanagement.service_tier.service.section_completion;

import com.ibs.customermanagement.service_tier.model.SectionCompletionDTO;
import org.springframework.stereotype.Service;

@Service
public interface SectionCompletionService {

    SectionCompletionDTO returnCustomerSectionCompletion(Integer customerId);
}
