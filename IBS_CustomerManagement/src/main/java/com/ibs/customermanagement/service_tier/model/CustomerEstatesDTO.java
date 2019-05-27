package com.ibs.customermanagement.service_tier.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerEstatesDTO {

    private int estateId;
    private String estateName;
    private String estateDescription;
    private String estateType;
    private double estateValue;
    private Integer customerId;
}
