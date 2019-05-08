package com.ibs.customermanagement.data_tier.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_ibs_customers_profiling", schema = "ibs_local_schema", catalog = "")
@Getter
@Setter
public class TIbsCustomersProfilingEntity {

    @Id
    @Column(name = "id_profiling")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProfiling;

    @Basic
    @Column(name = "id_customer")
    private int idCustomer;

    @Basic
    @Column(name = "profession")
    private String profession;

    @Basic
    @Column(name = "residence_city")
    private String residenceCity;

    @Basic
    @Column(name = "residence_province")
    private String residenceProvince;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TIbsCustomersProfilingEntity that = (TIbsCustomersProfilingEntity) o;
        return idProfiling == that.idProfiling &&
                idCustomer == that.idCustomer &&
                Objects.equals(profession, that.profession) &&
                Objects.equals(residenceCity, that.residenceCity) &&
                Objects.equals(residenceProvince, that.residenceProvince);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProfiling, idCustomer, profession, residenceCity, residenceProvince);
    }
}
