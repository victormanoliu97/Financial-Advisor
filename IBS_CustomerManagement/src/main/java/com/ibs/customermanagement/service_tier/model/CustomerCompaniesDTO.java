package com.ibs.customermanagement.service_tier.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerCompaniesDTO {

    private int idCompany;
    private String companyName;
    private String companyDescription;
    private String companyType;
    private double companyRevenue;
    private Integer customerId;
}
