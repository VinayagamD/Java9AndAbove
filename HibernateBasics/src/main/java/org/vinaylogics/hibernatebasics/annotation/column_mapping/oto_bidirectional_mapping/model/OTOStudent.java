package org.vinaylogics.hibernatebasics.annotation.column_mapping.oto_bidirectional_mapping.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "students_oto_bm")
public class OTOStudent {
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
    private OTOBMAddress address;

    public OTOStudent() {
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

    public OTOBMAddress getAddress() {
        return address;
    }

    public void setAddress(OTOBMAddress address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OTOStudent student = (OTOStudent) o;
        return id == student.id &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(section, student.section);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, section);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", section='" + section + '\'' +
                '}';
    }
}
