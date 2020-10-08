package com.vinaylogics.hibernate_mapping.table_inheritance.models.joined_table;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "joinedTableContractEmployee")
@Table(name = "contract_employee")
@PrimaryKeyJoinColumn(name = "ID")
@DiscriminatorValue("CONTRACT")
public class ContractEmployee extends Employee {

    private static final long serialVersionUID = -5301317111247065217L;

    @Column(name = "contract_start_date")
    private LocalDate contractStartDate;
    @Column(name="contract_end_date")
    private LocalDate contractEndDate;
    @Column(name = "agency_name")
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
