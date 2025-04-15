package com.influencer.education.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "University")
@Table(name = "university")
public class University {
    @Id
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "university",
            targetEntity = Student.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    @JsonIgnore
    private List<Student> students;

    public Integer getId() {
        return id;
    }

    public University setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public University setName(String name) {
        this.name = name;
        return this;
    }

    public List<Student> getStudents() {
        return students;
    }

    public University setStudents(List<Student> students) {
        this.students = students;
        return this;
    }
}
