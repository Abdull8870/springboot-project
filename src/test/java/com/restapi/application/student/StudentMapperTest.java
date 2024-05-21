package com.restapi.application.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        this.studentMapper=new StudentMapper();
    }

    @Test
    public void getStudentResponse(){

        Student student=new Student(
                "Abdul","Rahuman","abdull8870@gmail.com",20 );

        StudentResponseDTO studentResponseDTO = studentMapper.studentResponse(student);

        Assertions.assertEquals(student.getFirstName(),studentResponseDTO.firstName());
        Assertions.assertEquals(student.getLastName(),studentResponseDTO.lastName());
        Assertions.assertEquals(student.getEmail(),studentResponseDTO.email());

    }
}