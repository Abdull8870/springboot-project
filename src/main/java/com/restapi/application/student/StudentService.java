package com.restapi.application.student;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private StudentRepository repository;

    private StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDTO saveStudent(StudentDTO stu){
        Student student = studentMapper.getStudent(stu);
        Student stuResponse=repository.save(student);
        return studentMapper.studentResponse(stuResponse);
    }

    public List<StudentResponseDTO> getAllStudents(){
        return repository.findAll().stream().map(studentMapper::getAllStudentsDTO).collect(
                Collectors.toList()
        );
    }

    public List<StudentResponseDTO> findStudentsByName(
            @PathVariable(name = "student-name") String name
    ){
        return repository.findAllByFirstNameContaining(name).
                stream().
                map(studentMapper::getAllStudentsDTO).collect(Collectors.toList());

    }

    public void deleteStudent(int id){
        repository.deleteById(id);
    }

    public StudentResponseDTO getStudentById(int id){
         Optional<Student> student=repository.findById(id);
         if(student.isPresent()){
             return new StudentResponseDTO(
                     student.get().getFirstName(),
                     student.get().getLastName(),
                     student.get().getEmail()
             );
         }else{
             return null;
         }


    }
}
