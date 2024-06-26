package com.restapi.application.school;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    private SchoolService schoolService;

    @PostMapping("/schools")
    public SchoolDTOResponse addSchool(@RequestBody SchoolDTO schoolDTO){
        return schoolService.addSchool(schoolDTO);
    }

    @GetMapping("/schools")
    public List<SchoolDTO> getSchool(){
        return  schoolService.getSchool();
    }
}
