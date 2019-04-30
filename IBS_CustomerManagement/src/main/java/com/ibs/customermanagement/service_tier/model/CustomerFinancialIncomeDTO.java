package com.ibs.customermanagement.service_tier.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerFinancialIncomeDTO {

    private int idFinancialIncome;
    private double incomeAmount;
    private String incomeSource;
    private Double compressibleCosts;
    private Double nonCompressibleCosts;
    private Integer customerId;
}
