package com.ibs.customermanagement.service_tier.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JobTypes {

    PRIVATE_EMPLOYEE("Private Employee"),
    PUBLIC_EMPLOYEE("Public Employee"),
    RETIRED("Retired"),
    UNEMPLOYED("Unemployed");

    private String jobType;
}
