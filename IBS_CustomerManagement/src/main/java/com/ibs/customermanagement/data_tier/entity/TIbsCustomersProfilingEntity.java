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
    @Basic
    @Column(name = "work_segment")
    private String workSegment;
    @Basic
    @Column(name = "current_job")
    private String currentJob;
    @Basic
    @Column(name = "birth_city")
    private String birthCity;
    @Basic
    @Column(name = "birth_residence")
    private String birthResidence;
    @Basic
    @Column(name = "gender")
    private String gender;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TIbsCustomersProfilingEntity entity = (TIbsCustomersProfilingEntity) o;
        return getIdProfiling() == entity.getIdProfiling() &&
                getIdCustomer() == entity.getIdCustomer() &&
                getProfession().equals(entity.getProfession()) &&
                getResidenceCity().equals(entity.getResidenceCity()) &&
                getResidenceProvince().equals(entity.getResidenceProvince()) &&
                getWorkSegment().equals(entity.getWorkSegment()) &&
                getCurrentJob().equals(entity.getCurrentJob()) &&
                getBirthCity().equals(entity.getBirthCity()) &&
                getBirthResidence().equals(entity.getBirthResidence()) &&
                getGender().equals(entity.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdProfiling(), getIdCustomer(), getProfession(), getResidenceCity(), getResidenceProvince(), getWorkSegment(), getCurrentJob(), getBirthCity(), getBirthResidence(), getGender());
    }
}
