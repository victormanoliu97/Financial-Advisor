package com.ibs.customermanagement.service_tier.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerBankAccountsDTO {

    private int idAccount;
    private String accountType;
    private int currentSold;
    private int loanAmount;
    private String iban;
    private String status;
    private Integer bankId;
    private Integer customerId;
}
