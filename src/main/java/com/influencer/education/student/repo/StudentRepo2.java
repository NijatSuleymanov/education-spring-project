package com.influencer.education.student.repo;
import com.influencer.education.student.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class StudentRepo2 implements IStudentRepo {
    @Autowired
    private EntityManager em;

    public StudentRepo2(final EntityManager em) {
        this.em = em;
    }

    public List<Student> getList(){//jpql  performansli query yaratmir bu jpql

        final TypedQuery<Student> findByName = em.createNamedQuery("findByName", Student.class);
        return findByName.getResultList();
//        final Query nativeQuery = em.createQuery("SELECT s.firstName, CONCAT(s.firstName,' ', s.surname) FROM MyStudent s", Student.class);
//        return nativeQuery.getResultList();
    }




    public void update(Student obj) {
        //
    }
    public void delete(Student obj) {
        //
    }

    public void insert(Student obj) {
        //
    }

    public Student findById(int id) {
        return null;
    }

    public List<Student> getList(String name,String surname, String email ,
                                 String university, Integer age, String password) {
         return null;
    }

}
