package org.vinaylogics.hibernatebasics.annotation.inheritance_mapping.singletable.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@DiscriminatorValue("CONTRACT")
public class ContractEmployee extends Employee{
    private LocalDate contractStartDate;
    private LocalDate contractEndDate;
    private String agencyName;

    public LocalDate getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(LocalDate contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public LocalDate getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(LocalDate contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ContractEmployee that = (ContractEmployee) o;
        return Objects.equals(contractStartDate, that.contractStartDate) &&
                Objects.equals(contractEndDate, that.contractEndDate) &&
                Objects.equals(agencyName, that.agencyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), contractStartDate, contractEndDate, agencyName);
    }

    @Override
    public String toString() {
        return "ContractEmployee{" +
                "contractStartDate=" + contractStartDate +
                ", contractEndDate=" + contractEndDate +
                ", agencyName='" + agencyName + '\'' +
                '}';
    }
}
