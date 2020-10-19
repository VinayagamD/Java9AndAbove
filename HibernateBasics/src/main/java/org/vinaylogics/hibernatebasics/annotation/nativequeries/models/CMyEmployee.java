package org.vinaylogics.hibernatebasics.annotation.nativequeries.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name="EmployeeEntity")
@Table(name = "employee")
@SqlResultSetMapping(name="getresult", columns = {
        @ColumnResult(name = "id"),
        @ColumnResult(name = "firstName"),
        @ColumnResult(name = "lastName")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "Employee.findall", query = "SELECT * FROM employee",
        resultSetMapping = "getresult")
})
public class CMyEmployee implements Serializable {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CMyEmployee that = (CMyEmployee) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "MyEmployee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}