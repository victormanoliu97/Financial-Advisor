package com.ibs.customermanagement.service_tier.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  CompaniesTypes {

    COLLECTIVE_SOCIETIES("COLLECTIVE SOCIETIES"),
    LIMITED_PARTNERSHIPS("LIMITED PARTNERSHIPS"),
    LIMITED_LIABILITY_COMPANIES("LIMITED LIABILITY COMPANIES(S.R.L)"),
    JOINT_STOCK_COMPANIES("JOINT STOCK COMPANIES(S.A.)");

    private String companyType;
}
