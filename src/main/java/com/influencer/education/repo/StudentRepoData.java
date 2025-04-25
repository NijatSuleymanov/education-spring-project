package com.influencer.education.repo;

import com.influencer.education.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepoData extends JpaRepository<Student, Integer> {

}
