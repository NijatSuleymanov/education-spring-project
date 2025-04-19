package com.influencer.education.student;
import com.influencer.education.student.dto.StudentDTO;
import com.influencer.education.student.dto.UniversityDTO;
import com.influencer.education.student.entity.Student;
import com.influencer.education.student.entity.University;
import com.influencer.education.student.repo.StudentRepoData;
import com.influencer.education.student.repo.CustomStudentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final CustomStudentRepo studentRepo;
    private final StudentRepoData dataRepo;

    public StudentController(final CustomStudentRepo studentRepo, final StudentRepoData dataRepo) {
        this.dataRepo = dataRepo;
        this.studentRepo = studentRepo;

    }

    @GetMapping
    public List<StudentDTO> getList(
          @RequestParam(required = false) String name,
          @RequestParam(required = false) String surname,
          @RequestParam(required = false) String email ,
          @RequestParam(required = false, name = "university_id") Integer universityId,
          @RequestParam(required = false) Integer age){

          return studentRepo.getList(name, surname, email, universityId, age)
                  .stream()
                  .map(StudentController ::toStudentDTO)
                  .collect(Collectors.toList());
    }

    @PostMapping
    public void insert(@RequestBody StudentDTO studentDto) {
        dataRepo.save(toStudentEntity(studentDto));
    }
    @PutMapping
    public void update(@RequestBody StudentDTO studentDto) {
        dataRepo.save(toStudentEntity(studentDto));
    }

    @DeleteMapping

    public void delete(@RequestParam Integer id) {
        dataRepo.deleteById(id);
    }

    @GetMapping("{id}")
    public StudentDTO findById(@PathVariable("id") Integer id) {
        return dataRepo.findById(id).map(StudentController ::toStudentDTO).orElse(new StudentDTO());
    }

    private static StudentDTO toStudentDTO(Student student) {
        return new StudentDTO()
                .setId(student.getId())
                .setFirstName(student.getFirstName())
                .setSurname(student.getSurname())
                .setAge(student.getAge())
                .setEmail(student.getEmail())
                .setUniversity(
                        new UniversityDTO()
                                .setId(student.getUniversity().getId())
                                .setName(student.getUniversity().getName())
                );
    }
    private static Student toStudentEntity(StudentDTO studentDto) {
        return new Student()
                .setId(studentDto.getId())
                .setFirstName(studentDto.getFirstName())
                .setSurname(studentDto.getSurname())
                .setAge(studentDto.getAge())
                .setEmail(studentDto.getEmail())
                .setUniversity(
                        new University()
                                .setId(studentDto.getUniversity().getId())
                                .setName(studentDto.getUniversity().getName())
                );
    }

}
