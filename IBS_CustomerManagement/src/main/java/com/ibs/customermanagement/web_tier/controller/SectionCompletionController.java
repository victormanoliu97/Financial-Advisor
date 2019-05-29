package com.ibs.customermanagement.web_tier.controller;

import com.ibs.customermanagement.service_tier.model.SectionCompletionDTO;
import com.ibs.customermanagement.service_tier.service.section_completion.SectionCompletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class SectionCompletionController {

    private final SectionCompletionService sectionCompletionService;

    @Autowired
    public SectionCompletionController(SectionCompletionService sectionCompletionService) {
        this.sectionCompletionService = sectionCompletionService;
    }

    @GetMapping(value = "/get-section-completion/{customerId}")
    public SectionCompletionDTO getSectionCompletion(@PathVariable Integer customerId) {
        return sectionCompletionService.returnCustomerSectionCompletion(customerId);
    }
}
