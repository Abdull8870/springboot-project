package com.restapi.application.school;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private SchoolMapper schoolMapper;
    private SchoolRepository schoolRepository;

    public SchoolService(SchoolMapper schoolMapper, SchoolRepository schoolRepository) {
        this.schoolMapper = schoolMapper;
        this.schoolRepository = schoolRepository;
    }

    public SchoolDTOResponse addSchool(@RequestBody SchoolDTO schoolDTO){
        School school = schoolMapper.getSchool(schoolDTO);
        School schoolSaved = schoolRepository.save(school);
        return schoolMapper.getSchoolResponse(schoolSaved);
    }


    public List<SchoolDTO> getSchool(){
        return schoolRepository.findAll().stream().
                map(schoolMapper::convertToSchoolDTO).
                collect(Collectors.toList());
    }
}
