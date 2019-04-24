package com.ibs.customermanagement.data_tier.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_ibs_customers_customer_financial_companies", schema = "ibs_local_schema", catalog = "")
@Getter
@Setter
public class TIbsCustomersCustomerFinancialCompaniesEntity {

    @Id
    @Column(name = "id_company")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCompany;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "company_description")
    private String companyDescription;

    @Column(name = "company_type")
    private String companyType;

    @Column(name = "company_revenue")
    private double companyRevenue;

    @Column(name = "id_customer")
    private Integer customerId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TIbsCustomersCustomerFinancialCompaniesEntity that = (TIbsCustomersCustomerFinancialCompaniesEntity) o;
        return idCompany == that.idCompany &&
                Double.compare(that.companyRevenue, companyRevenue) == 0 &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(companyDescription, that.companyDescription) &&
                Objects.equals(companyType, that.companyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCompany, companyName, companyDescription, companyType, companyRevenue);
    }
}
