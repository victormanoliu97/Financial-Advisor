package com.ibs.customermanagement.service_tier.utils;

import com.ibs.customermanagement.service_tier.constants.CompaniesTypes;
import com.ibs.customermanagement.service_tier.constants.JobTypes;
import com.ibs.customermanagement.service_tier.constants.IncomeTypes;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GeneralUtills {

    private List<String> incomeTypes = Stream.of(IncomeTypes.values()).map(IncomeTypes::getIncomeType).collect(Collectors.toList());
    private List<String> companiesTypes = Stream.of(CompaniesTypes.values()).map(CompaniesTypes::getCompanyType).collect(Collectors.toList());
    private List<String> jobTypes = Stream.of(JobTypes.values()).map(JobTypes::getJobType).collect(Collectors.toList());

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

    public boolean validateJobType(String jobType) {return jobTypes.contains(jobType); }
}
