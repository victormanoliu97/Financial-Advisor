package com.ibs.customermanagement.data_tier.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_ibs_bank_information", schema = "ibs_local_schema", catalog = "")
public class TIbsBankInformationEntity {
    private int idBank;
    private String bankName;
    private double administrativeCommission;
    private double lendingRate;

    @Id
    @Column(name = "id_bank")
    public int getIdBank() {
        return idBank;
    }

    public void setIdBank(int idBank) {
        this.idBank = idBank;
    }

    @Basic
    @Column(name = "bank_name")
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Basic
    @Column(name = "administrative_commission")
    public double getAdministrativeCommission() {
        return administrativeCommission;
    }

    public void setAdministrativeCommission(double administrativeCommission) {
        this.administrativeCommission = administrativeCommission;
    }

    @Basic
    @Column(name = "lending_rate")
    public double getLendingRate() {
        return lendingRate;
    }

    public void setLendingRate(double lendingRate) {
        this.lendingRate = lendingRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TIbsBankInformationEntity that = (TIbsBankInformationEntity) o;
        return idBank == that.idBank &&
                Double.compare(that.administrativeCommission, administrativeCommission) == 0 &&
                Double.compare(that.lendingRate, lendingRate) == 0 &&
                Objects.equals(bankName, that.bankName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBank, bankName, administrativeCommission, lendingRate);
    }
}
