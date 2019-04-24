package com.ibs.customermanagement.service_tier.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GeneralConstants {

    CLOSED_ACCOUNT("CLOSED"),
    CREATED_ACCOUNT("CREATED");

    private String status;
}
