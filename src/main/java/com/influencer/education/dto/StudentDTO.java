package com.influencer.education.dto;


public class StudentDTO {
    private  Integer id;
    private  String firstName;

    private  String surname;
    private  Integer age;
    private  String email;
    private  String password;
    private UniversityDTO university;

    public String getFirstName() {
        return firstName;
    }

    public Integer getId() {
        return id;
    }

    public StudentDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public StudentDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public StudentDTO setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public StudentDTO setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public StudentDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public StudentDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public UniversityDTO getUniversity() {
        return university;
    }

    public StudentDTO setUniversity(UniversityDTO university) {
        this.university = university;
        return this;
    }
}
