package com.ibs.customermanagement.data_tier.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_ibs_customers_customer_financial_estates", schema = "ibs_local_schema", catalog = "")
@Getter
@Setter
public class TIbsCustomersCustomerFinancialEstatesEntity {

    @Id
    @Column(name = "id_estate")
    private int idEstate;

    @Basic
    @Column(name = "estate_name")
    private String estateName;

    @Basic
    @Column(name = "estate_description")
    private String estateDescription;

    @Basic
    @Column(name = "estate_type")
    private String estateType;

    @Basic
    @Column(name = "estate_value")
    private double estateValue;

    @Column(name = "id_customer")
    private Integer customerId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TIbsCustomersCustomerFinancialEstatesEntity that = (TIbsCustomersCustomerFinancialEstatesEntity) o;
        return idEstate == that.idEstate &&
                Double.compare(that.estateValue, estateValue) == 0 &&
                Objects.equals(estateName, that.estateName) &&
                Objects.equals(estateDescription, that.estateDescription) &&
                Objects.equals(estateType, that.estateType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstate, estateName, estateDescription, estateType, estateValue);
    }
}
