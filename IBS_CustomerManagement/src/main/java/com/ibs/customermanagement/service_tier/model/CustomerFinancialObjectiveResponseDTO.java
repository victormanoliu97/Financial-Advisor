package com.ibs.customermanagement.service_tier.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerFinancialObjectiveResponseDTO {

    private int id;
    private Integer customerId;
    private double income;
    private double objectiveValue;
    private int years;
    private Integer possible;
}
