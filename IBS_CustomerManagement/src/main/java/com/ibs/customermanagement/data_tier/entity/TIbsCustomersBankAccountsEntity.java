package com.ibs.customermanagement.data_tier.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_ibs_customers_bank_accounts", schema = "ibs_local_schema", catalog = "")
@Getter
@Setter
public class TIbsCustomersBankAccountsEntity {

    @Id
    @Column(name = "id_account")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idAccount;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "current_sold")
    private int currentSold;

    @Column(name = "loan_amount")
    private int loanAmount;

    @Column(name = "iban")
    private String iban;

    @Column(name = "status")
    private String status;

    @Column(name = "id_bank")
    private Integer bankId;

    @Column(name = "id_customer")
    private Integer customerId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TIbsCustomersBankAccountsEntity that = (TIbsCustomersBankAccountsEntity) o;
        return idAccount == that.idAccount &&
                currentSold == that.currentSold &&
                loanAmount == that.loanAmount &&
                Objects.equals(accountType, that.accountType) &&
                Objects.equals(iban, that.iban) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAccount, accountType, currentSold, loanAmount, iban, status);
    }
}
