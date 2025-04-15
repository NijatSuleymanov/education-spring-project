package com.influencer.education.student.repo;

import com.influencer.education.student.entity.Student;
import com.influencer.education.student.entity.StudentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MyDataStudentRepo  extends JpaRepository<Student, Integer> {

    @Query(nativeQuery = true,value ="SELECT *, CONCAT(name,' ',surname) AS fullname FROM students")
    public List<StudentProjection> getAll();

}
