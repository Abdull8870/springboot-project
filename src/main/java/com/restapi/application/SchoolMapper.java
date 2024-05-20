package com.restapi.application;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

    public SchoolDTOResponse getSchoolResponse(School school){
        return new SchoolDTOResponse(school.getName());
    }

    public School getSchool(SchoolDTO schoolDTO){
        return new School(schoolDTO.schoolName());
    }

    public SchoolDTO convertToSchoolDTO(School school){
        return new SchoolDTO(school.getName());
    }
}
