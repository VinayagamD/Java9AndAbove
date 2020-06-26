package com.vinaylogics.hibernate.storedprocedure.model;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Employee")
@Table(name="employee")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "Employee.findAll",
                procedureName = "get_all_employee",
                resultClasses = {Employee.class}
        ),
        @NamedStoredProcedureQuery(
                name = "Employee.findById",
                procedureName = "find_employee_by_id",
                resultClasses = {Employee.class},
                parameters = {
                        @StoredProcedureParameter(
                                name = "id",
                                type = Integer.class,
                                mode = ParameterMode.IN
                        )
                }
        ),
        @NamedStoredProcedureQuery(
                name= "Employee.count",
                procedureName = "get_employee_count",
                parameters = {
                        @StoredProcedureParameter(
                                name = "count",
                                type = Integer.class,
                                mode = ParameterMode.OUT
                        )
                }
        )
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String firstName;
    private String lastName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
