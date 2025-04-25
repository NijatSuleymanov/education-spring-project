package com.influencer.education.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity(name = "MyStudent")
@Table(name = "students")
@DynamicUpdate
@NamedQuery(name = "findByName",query = "select s from MyStudent s where s.firstName =:name ")
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(name="name")
    private  String firstName;
    private  String surname;
    private  Integer age;
    private  String email;
    private  String password;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "university_id",nullable = false)
    private University university;

    public Integer getId() {
        return id;
    }

    public Student setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Student setFirstName(String name) {
        this.firstName = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Student setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Student setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Student setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Student setPassword(String password) {
        this.password = password;
        return this;
    }

    public University getUniversity() {
        return university;
    }

    public Student setUniversity(University university) {
        this.university = university;
        return this;
    }
}
