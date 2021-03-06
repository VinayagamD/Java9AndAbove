package com.vinaylogics.nativequery.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "Employee")
@Table(name = "employee")
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Employee.findall",
                query = "SELECT  * FROM employee",
                resultClass = Employee.class
        ),
        @NamedNativeQuery(
                name = "Employee.findById",
                query = "SELECT * FROM employee WHERE id=:id",
                resultClass = Employee.class
        )
})
public class Employee implements Serializable {

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
