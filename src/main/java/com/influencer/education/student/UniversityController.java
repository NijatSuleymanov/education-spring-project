package com.influencer.education.student;
import com.influencer.education.student.entity.University;
import com.influencer.education.student.repo.MyDataUniversityRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {

    private final MyDataUniversityRepo dataRepo;

    public UniversityController( final MyDataUniversityRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    @GetMapping
    public List<University> getList(){
         return dataRepo.findAll();
    }


}
