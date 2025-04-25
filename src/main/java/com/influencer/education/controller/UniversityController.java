package com.influencer.education.controller;
import com.influencer.education.entity.University;
import com.influencer.education.repo.MyDataUniversityRepo;
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
    public List<University> getList(@RequestParam(required = false) String name) {

        if ("TEST".equalsIgnoreCase(name)) {
            throw new IllegalArgumentException("TEST -e icaze yoxdur");
        }
         return dataRepo.findAll();
    }


}
