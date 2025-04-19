package com.influencer.education.student;
import com.influencer.education.common.dto.CommonDTO;
import com.influencer.education.student.dto.StudentDTO;
import com.influencer.education.student.dto.StudentMapper;
import com.influencer.education.student.dto.UniversityDTO;
import com.influencer.education.student.entity.Student;
import com.influencer.education.student.entity.University;
import com.influencer.education.student.repo.StudentRepoData;
import com.influencer.education.student.repo.CustomStudentRepo;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public CommonDTO getList(
          @RequestParam(required = false) String name,
          @RequestParam(required = false) String surname,
          @RequestParam(required = false) String email ,
          @RequestParam(required = false, name = "university_id") Integer universityId,
          @RequestParam(required = false) Integer age){

          return new CommonDTO()
                  .setObj( studentRepo.getList(name, surname, email, universityId, age)
                                  .stream()
                                  .map(StudentMapper.MAPPER::toDto)
                                  .collect(Collectors.toList()))
                  .setTime(LocalDateTime.now());
    }

    @PostMapping
    public CommonDTO insert(@RequestBody StudentDTO studentDto) {
        dataRepo.save(StudentMapper.MAPPER.toEntity(studentDto));
        return new CommonDTO()
                .setTime(LocalDateTime.now())
                .setMsg("Student inserted successfully");
    }
    @PutMapping
    public CommonDTO update(@RequestBody StudentDTO studentDto) {
        dataRepo.save(StudentMapper.MAPPER.toEntity(studentDto));
        return new CommonDTO()
                .setTime(LocalDateTime.now())
                .setMsg("Student updated successfully");
    }

    @DeleteMapping

    public CommonDTO delete(@RequestParam Integer id) {
        dataRepo.deleteById(id);
        return new CommonDTO()
                .setTime(LocalDateTime.now())
                .setMsg("Student deleted successfully");
    }

    @GetMapping("{id}")
    public CommonDTO findById(@PathVariable("id") Integer id) {
        return new CommonDTO().setObj(
                dataRepo.findById(id).map(StudentMapper.MAPPER::toDto).orElse(new StudentDTO())
        )
                .setTime(LocalDateTime.now());
    }




}
