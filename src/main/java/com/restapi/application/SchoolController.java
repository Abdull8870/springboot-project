package com.restapi.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {

    private SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public SchoolDTOResponse addSchool(@RequestBody SchoolDTO schoolDTO){
        School school = getSchool(schoolDTO);
        School schoolSaved = schoolRepository.save(school);
        return getSchoolResponse(schoolSaved);
    }

    private SchoolDTOResponse getSchoolResponse(School school){
        return new SchoolDTOResponse(school.getName());
    }

    private School getSchool(SchoolDTO schoolDTO){
        return new School(schoolDTO.schoolName());
    }

    private SchoolDTO convertToSchoolDTO(School school){
        return new SchoolDTO(school.getName());
    }

    @GetMapping("/schools")
    public List<SchoolDTO> getSchool(){
        return schoolRepository.findAll().stream().
                map(this::convertToSchoolDTO).
                collect(Collectors.toList());
    }
}
