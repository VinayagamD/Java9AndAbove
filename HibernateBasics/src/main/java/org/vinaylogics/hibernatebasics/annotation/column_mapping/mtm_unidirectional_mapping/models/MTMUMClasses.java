package org.vinaylogics.hibernatebasics.annotation.column_mapping.mtm_unidirectional_mapping.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "classes_mtm_um")
public class Classes implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String subject;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "classes_students",
                joinColumns = {@JoinColumn(name = "classes_id")},
                inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private Set<MTMUMStudent> students = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Set<MTMUMStudent> getStudents() {
        return students;
    }

    public void setStudents(Set<MTMUMStudent> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classes classes = (Classes) o;
        return id == classes.id &&
                Objects.equals(name, classes.name) &&
                Objects.equals(subject, classes.subject) &&
                Objects.equals(students, classes.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, subject, students);
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", students=" + students +
                '}';
    }
}
