package com.influencer.education.student;
import com.influencer.education.student.entity.Student;
import com.influencer.education.student.entity.University;
import com.influencer.education.student.repo.StudentRepoData;
import com.influencer.education.student.repo.CustomStudentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final CustomStudentRepo studentRepo;

    private final StudentRepoData dataRepo;

    public StudentController(final CustomStudentRepo studentRepo, final StudentRepoData dataRepo) {
        this.studentRepo = studentRepo;
        this.dataRepo = dataRepo;
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
    public void insert(@RequestBody Student student) {
        dataRepo.save(student);
    }
    @PutMapping
    public void update(@RequestBody Student student) {
        dataRepo.save(student);
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id) {
        dataRepo.deleteById(id);
    }

    @GetMapping("{id}")
    public Student findById(@PathVariable("id") Integer id) {
        return dataRepo.findById(id).isPresent() ?
                dataRepo.findById(id).get() : null;
    }

    @GetMapping("{id}/universities/{universityId}")
    public University findByIdUniversity(
            @PathVariable("id") Integer id,
            @PathVariable("universityId") Integer universityId) {
        return dataRepo.findById(id).isPresent() ?
                dataRepo.findById(id).get().getUniversity() : null;
    }

}
