package com.ibs.customermanagement.data_tier.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_ibs_customers_customer_financial_liabilities", schema = "ibs_local_schema", catalog = "")
public class TIbsCustomersCustomerFinancialLiabilitiesEntity {
    private int idFinancialLiability;
    private double liabilitiesAmount;
    private String liabilitiesSource;

    @Column(name = "id_customer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Id
    @Column(name = "id_financial_liability")
    public int getIdFinancialLiability() {
        return idFinancialLiability;
    }

    public void setIdFinancialLiability(int idFinancialLiability) {
        this.idFinancialLiability = idFinancialLiability;
    }

    @Basic
    @Column(name = "liabilities_amount")
    public double getLiabilitiesAmount() {
        return liabilitiesAmount;
    }

    public void setLiabilitiesAmount(double liabilitiesAmount) {
        this.liabilitiesAmount = liabilitiesAmount;
    }

    @Basic
    @Column(name = "liabilities_source")
    public String getLiabilitiesSource() {
        return liabilitiesSource;
    }

    public void setLiabilitiesSource(String liabilitiesSource) {
        this.liabilitiesSource = liabilitiesSource;
    }

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
