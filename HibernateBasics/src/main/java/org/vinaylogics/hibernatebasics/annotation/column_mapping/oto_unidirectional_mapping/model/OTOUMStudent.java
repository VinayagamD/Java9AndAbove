package org.vinaylogics.hibernatebasics.annotation.column_mapping.oto_unidirectional_mapping.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "students_oto_um")
public class OTOUMStudent {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "section")
    private String section;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private OTOUMAddress address;

    public OTOUMStudent() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public OTOUMAddress getAddress() {
        return address;
    }

    public void setAddress(OTOUMAddress address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OTOUMStudent student = (OTOUMStudent) o;
        return id == student.id &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(section, student.section) &&
                Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, section, address);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", section='" + section + '\'' +
                ", address=" + address +
                '}';
    }
}
