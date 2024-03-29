package org.vinaylogics.hibernatebasics.annotation.inheritance_mapping.joined_tableclass.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "joinedTableClassPermanentEmployee")
@Table(name = "permanent_employees_jtc")
@PrimaryKeyJoinColumn(name = "ID")
@DiscriminatorValue("PERMANENT")
public class PermanentEmployee extends InMEmployee {
    private LocalDate startDate;
    private String costCenter;
    private String totalLeaves;

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public String getTotalLeaves() {
        return totalLeaves;
    }

    public void setTotalLeaves(String totalLeaves) {
        this.totalLeaves = totalLeaves;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PermanentEmployee that = (PermanentEmployee) o;
        return Objects.equals(startDate, that.startDate) &&
                Objects.equals(costCenter, that.costCenter) &&
                Objects.equals(totalLeaves, that.totalLeaves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), startDate, costCenter, totalLeaves);
    }

    @Override
    public String toString() {
        return "PermanentEmployee{" +
                "startDate=" + startDate +
                ", costCenter='" + costCenter + '\'' +
                ", totalLeaves='" + totalLeaves + '\'' +
                '}';
    }
}
