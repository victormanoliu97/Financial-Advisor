package com.ibs.customermanagement.data_tier.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_ibs_customer_financial_objectives", schema = "ibs_local_schema", catalog = "")
@Getter
@Setter
public class TIbsCustomerFinancialObjectivesEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_customer")
    private Integer customerId;

    @Basic
    @Column(name = "income")
    private double income;

    @Basic
    @Column(name = "objective_value")
    private double objectiveValue;

    @Basic
    @Column(name = "years")
    private int years;

    @Basic
    @Column(name = "possible")
    private Integer possible;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TIbsCustomerFinancialObjectivesEntity that = (TIbsCustomerFinancialObjectivesEntity) o;
        return id == that.id &&
                Double.compare(that.income, income) == 0 &&
                Double.compare(that.objectiveValue, objectiveValue) == 0 &&
                years == that.years &&
                Objects.equals(possible, that.possible);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, income, objectiveValue, years, possible);
    }
}
