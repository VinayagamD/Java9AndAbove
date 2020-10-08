package com.vinaylogics.hibernate_mapping.table_inheritance.models.joined_table;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "joinedTablePermanentEmployee")
@Table(name = "permanent_employee")
@PrimaryKeyJoinColumn(name = "ID")
@DiscriminatorValue("PERMANENT")
public class PermanentEmployee extends Employee {

    private static final long serialVersionUID = -5301317111247065217L;

    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "cost_center")
    private String costCenter;
    @Column(name = "total_leaves")
    private Float totalLeaves;

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

    public Float getTotalLeaves() {
        return totalLeaves;
    }

    public void setTotalLeaves(Float totalLeaves) {
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
                ", totalLeaves=" + totalLeaves +
                '}';
    }
}
