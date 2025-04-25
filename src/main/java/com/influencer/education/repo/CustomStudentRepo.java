package com.influencer.education.repo;
import com.influencer.education.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;


@Component
public class CustomStudentRepo {

    private final EntityManager em;

    public CustomStudentRepo(final EntityManager em) {
        this.em = em;
    }

    public List<Student> getList(String name,
                                 String surname,
                                 String email ,
                                 Integer universityId,
                                 Integer age) {

        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        final Root<Student> root = cq.from(Student.class);
        final List<Predicate> predicates = new ArrayList<>();
        if (name != null && !name.isEmpty()) {
            //WHERE name LIKE '%name%'
            predicates.add(cb.like(root.get("firstName"),"%" + name + "%"));
        }
        if (surname != null && !surname.isEmpty()) {
            //WHERE surname LIKE '%surname%'
            predicates.add(cb.like(root.get("surname"),"%" + surname + "%"));
        }
        if (email != null && !email.isEmpty()) {
            //WHERE email LIKE '%email%'
            predicates.add(cb.like(root.get("email"),"%" + email + "%"));
        }
        if (age != null) {
            //WHERE age ='email'
            predicates.add(cb.equal(root.get("age"), age));
        }
        if (universityId != null) {
            predicates.add(cb.equal(root.get("university").get("id"), universityId ));
        }

        final Predicate and = cb.and(predicates.toArray(new Predicate[0]));
        cq.where(and);
        cq.select(root);
        return em.createQuery(cq).getResultList();
    }

}
