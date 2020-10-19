package org.vinaylogics.hibernatebasics.annotation.column_mapping.mto_unidirectional_mapping.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "students_mto_um")
public class MTOUMStudent {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "section")
    private String section;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "university_id")
    private MTOUMUniversity university;

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

    public MTOUMUniversity getUniversity() {
        return university;
    }

    public void setUniversity(MTOUMUniversity university) {
        this.university = university;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MTOUMStudent student = (MTOUMStudent) o;
        return id == student.id &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(section, student.section) &&
                Objects.equals(university, student.university);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, section, university);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", section='" + section + '\'' +
                ", university=" + university +
                '}';
    }
}
