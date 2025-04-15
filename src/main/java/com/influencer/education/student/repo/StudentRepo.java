package com.influencer.education.student.repo;
import com.influencer.education.student.entity.Student;
import com.influencer.education.student.entity.StudentProjection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;


@Component
public class StudentRepo implements IStudentRepo {
    @Autowired
    private EntityManager em;

    public StudentRepo(final EntityManager em) {
        this.em = em;
    }

    public StudentRepo setEm(final EntityManager em) {
        this.em = em;
        return this;
    }

    public List<Student> getList(){//jpql  performansli query yaratmir bu jpql
        final Query nativeQuery = em.createQuery("SELECT s.firstName, CONCAT(s.firstName,' ', s.surname) FROM MyStudent s", Student.class);
        return nativeQuery.getResultList();

    }




    public void update(Student obj) {
        //
    }
    public void delete(Student obj) {
        //
    }
    @Transactional(rollbackFor = SQLException.class)
    public void insert(Student obj) {
        em.persist(obj);
    }

    public Student findById(int id) {
        return null;
    }

    public List<Student> getList(String name,String surname, String email ,
                                 String university, Integer age, String password) {
         return null;
    }

}
