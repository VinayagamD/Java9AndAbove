package org.vinaylogics.hibernatebasics.xmlconfiguration.models;

import java.io.Serializable;
import java.util.Objects;


public class XmlEmployee implements Serializable {

    private int id;
    private String firstName;
    private String lastName;
    private XMLAddress address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public XMLAddress getAddress() {
        return address;
    }

    public void setAddress(XMLAddress address) {
        this.address = address;
    }

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
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
                ", latsName='" + lastName + '\'' +
                '}';
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XmlEmployee xmlEmployee = (XmlEmployee) o;
        return id == xmlEmployee.id &&
                Objects.equals(firstName, xmlEmployee.firstName) &&
                Objects.equals(lastName, xmlEmployee.lastName) &&
                Objects.equals(address, xmlEmployee.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }
}
