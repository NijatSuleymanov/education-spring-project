package com.influencer.education.student.repo;
import com.influencer.education.student.entity.Student;


import java.util.List;

public interface IStudentRepo {

    List<Student> getList();

    void update(Student obj);

    void delete(Integer id);

    void insert(Student obj);

    Student findById(int id);

    List<Student> getList(String name,String surname, String email ,
                                 String university, Integer age, String password);

}
