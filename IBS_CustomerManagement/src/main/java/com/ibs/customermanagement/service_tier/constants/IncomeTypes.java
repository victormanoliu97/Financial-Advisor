package com.ibs.customermanagement.service_tier.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IncomeTypes {

    INDEPENDENT_ACTIVITIES("INDEPENDENT ACTIVITIES"),
    INTELECTUAL_PROPERTY_RIGHTS("INTELlECTUAL PROPERTYRIGHTS"),
    AGRICULTURAL_ACTIVITIES("AGRICULTURAL ACTIVITIES"),
    SILVICULTURE("SILVICULTURE"),
    PISCICULTURE("PISCICULTURE"),
    TOURISM_GOODS_TRANSFER("TRANSFER OF THE USER OF THE GOODS FOR TOURISM PURPOSES");

    private String incomeType;
}
