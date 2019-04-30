package com.ibs.customermanagement.data_tier.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_ibs_customers_customer_financial_income", schema = "ibs_local_schema", catalog = "")
@Getter
@Setter
public class TIbsCustomersCustomerFinancialIncomeEntity {

    @Id
    @Column(name = "id_financial_income")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFinancialIncome;

    @Basic
    @Column(name = "income_amount")
    private double incomeAmount;

    @Basic
    @Column(name = "income_source")
    private String incomeSource;

    @Basic
    @Column(name = "compressible_costs")
    private Double compressibleCosts;

    @Basic
    @Column(name = "non_compressible_costs")
    private Double nonCompressibleCosts;

    @Column(name = "id_customer")
    private Integer customerId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TIbsCustomersCustomerFinancialIncomeEntity that = (TIbsCustomersCustomerFinancialIncomeEntity) o;
        return idFinancialIncome == that.idFinancialIncome &&
                Double.compare(that.incomeAmount, incomeAmount) == 0 &&
                Objects.equals(incomeSource, that.incomeSource) &&
                Objects.equals(compressibleCosts, that.compressibleCosts) &&
                Objects.equals(nonCompressibleCosts, that.nonCompressibleCosts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFinancialIncome, incomeAmount, incomeSource, compressibleCosts, nonCompressibleCosts);
    }
}
