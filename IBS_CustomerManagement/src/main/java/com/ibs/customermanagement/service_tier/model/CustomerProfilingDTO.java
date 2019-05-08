package com.ibs.customermanagement.service_tier.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerProfilingDTO {

    private int idProfiling;
    private int idCustomer;
    private String profession;
    private String residenceCity;
    private String residenceProvince;
}
