package com.ibs.customermanagement.data_tier.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_ibs_customers_customer_financial_liabilities", schema = "ibs_local_schema", catalog = "")
@Getter
@Setter
public class TIbsCustomersCustomerFinancialLiabilitiesEntity {

    @Id
    @Column(name = "id_financial_liability")
    private int idFinancialLiability;

    @Basic
    @Column(name = "liabilities_amount")
    private double liabilitiesAmount;

    @Basic
    @Column(name = "liabilities_source")
    private String liabilitiesSource;

    @Column(name = "id_customer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TIbsCustomersCustomerFinancialLiabilitiesEntity that = (TIbsCustomersCustomerFinancialLiabilitiesEntity) o;
        return idFinancialLiability == that.idFinancialLiability &&
                Double.compare(that.liabilitiesAmount, liabilitiesAmount) == 0 &&
                Objects.equals(liabilitiesSource, that.liabilitiesSource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFinancialLiability, liabilitiesAmount, liabilitiesSource);
    }
}
