package com.influencer.education.student;
import com.influencer.education.student.entity.Student;
import com.influencer.education.student.repo.StudentRepoData;
import com.influencer.education.student.repo.CustomStudentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final CustomStudentRepo studentRepo;

    private final StudentRepoData myDataStudentRepo;

    public StudentController(final CustomStudentRepo studentRepo, final StudentRepoData myDataStudentRepo) {
        this.studentRepo = studentRepo;
        this.myDataStudentRepo = myDataStudentRepo;
    }

    @GetMapping
    public List<Student> getList(
          @RequestParam(required = false) String name,
          @RequestParam(required = false) String surname,
          @RequestParam(required = false) String email ,
          @RequestParam(required = false, name = "university_id") Integer universityId,
          @RequestParam(required = false) Integer age){
          return studentRepo.getList(name,surname,email,universityId,age);
    }

    @PostMapping
    public void save(@RequestBody Student student) {
        myDataStudentRepo.save(student);
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id) {
        myDataStudentRepo.deleteById(id);
    }
}
