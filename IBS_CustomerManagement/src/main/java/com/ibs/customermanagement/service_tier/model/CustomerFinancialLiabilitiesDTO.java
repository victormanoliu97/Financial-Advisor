package com.ibs.customermanagement.service_tier.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerFinancialLiabilitiesDTO {

    private int idFinancialLiability;

    private double liabilitiesAmount;

    private String liabilitiesSource;

    private Integer customerId;
}
