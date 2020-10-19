package org.vinaylogics.hibernatebasics.annotation.column_mapping.mtm_bidirectional_mapping.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "students_mtm_bm")
public class MTMStudent implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "section")
    private String section;


    @ManyToMany(mappedBy = "students")
    private Set<MTMBMClasses> classes = new HashSet<>();

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

    public Set<MTMBMClasses> getClasses() {
        return classes;
    }

    public void setClasses(Set<MTMBMClasses> classes) {
        this.classes = classes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MTMStudent student = (MTMStudent) o;
        return id == student.id &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(section, student.section) ;
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
