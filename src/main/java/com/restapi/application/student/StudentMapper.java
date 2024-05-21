package com.restapi.application.student;

import com.restapi.application.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public StudentResponseDTO studentResponse(Student student){
        StudentResponseDTO studentResponseDTO=new StudentResponseDTO(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );

        return studentResponseDTO;
    }

    public Student getStudent(StudentDTO stu){
        Student student=new Student();
        student.setAge(stu.age());
        student.setEmail(stu.email());
        student.setFirstName(stu.firstName());
        student.setLastName(stu.lastName());
        School school=new School();
        school.setId(stu.schoolId());
        student.setSchool(school);
        return student;
    }

    public StudentResponseDTO getAllStudentsDTO(Student student){
        return new StudentResponseDTO(student.getFirstName(),
                student.getLastName(),
                student.getEmail());
    }


}
