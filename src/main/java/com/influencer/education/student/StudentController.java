package com.influencer.education.student;
import com.influencer.education.student.entity.Student;
import com.influencer.education.student.entity.StudentProjection;
import com.influencer.education.student.repo.IStudentRepo;
import com.influencer.education.student.repo.MyDataStudentRepo;
import com.influencer.education.student.repo.StudentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepo studentRepo;

    private final MyDataStudentRepo myDataStudentRepo;

    public StudentController( final StudentRepo studentRepo, final MyDataStudentRepo myDataStudentRepo) {
        this.studentRepo = studentRepo;
        this.myDataStudentRepo = myDataStudentRepo;
    }

    @GetMapping
    public List<Student> getList(){
          return myDataStudentRepo.findAll();
    }

    @PostMapping
    public void save(@RequestBody Student student) {
        studentRepo.insert(student);
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id) {
        studentRepo.delete(id);
    }
}
