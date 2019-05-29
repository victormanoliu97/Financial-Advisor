package com.ibs.customermanagement.service_tier.utils;

import com.ibs.customermanagement.service_tier.constants.CompaniesTypes;
import com.ibs.customermanagement.service_tier.constants.JobTypes;
import com.ibs.customermanagement.service_tier.constants.IncomeTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GeneralUtills {

    private ArrayList<IncomeTypes> incomeTypes = new ArrayList<>(Arrays.asList(IncomeTypes.values()));
    private ArrayList<CompaniesTypes> companiesTypes = new ArrayList<>(Arrays.asList(CompaniesTypes.values()));
    private ArrayList<JobTypes> jobtypes = new ArrayList<>(Arrays.asList(JobTypes.values()));

    public String generateIban() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RO");
        stringBuilder.append(new Random().nextInt(90)+10);
        stringBuilder.append(new Random().nextInt(10)+1000000000);
        return String.valueOf(stringBuilder);
    }

    public boolean validateIncomeType(String incomeType) {
        return incomeTypes.contains(incomeType);
    }

    public boolean validateCompanyType(String companyType) {
        return companiesTypes.contains(companyType);
    }

    public boolean validateJobType(String jobType) {return jobtypes.contains(jobType); }
}
