package com.influencer.education.student.repo;

import com.influencer.education.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepoData extends JpaRepository<Student, Integer> {

}
