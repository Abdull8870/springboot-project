package com.restapi.application;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/hello")
    public String getHello() {
        return "Hello world";
    }

    @PostMapping("/data")
    public String postData(@RequestBody String name){ return "data posted successfully" +name; }

    @PostMapping("/post-order")
    public String post(@RequestBody Order order){
        return "Requested accepted and the message is :"+order.toString();
    }

//    @PostMapping("/post-order-record")
//    public String postOrder(@RequestBody OrderRecord order){
//        return "Requested accepted and the message is :"+order.toString();
//    }

    @PostMapping("/post-order-record")
    public String postOrder(@RequestBody Student order){
        return "Requested accepted and the message is :"+order.toString();
    }

    @GetMapping("/hello/{names}")
    public String pathParam(@PathVariable("names") String name){
        return "The value in Path Param is "+name;
    }

    @GetMapping("/hello/request-param")
    public String requestParam(
            @RequestParam("user-name") String userName,
            @RequestParam("password") String password
    ){
        return "the username entered = "+userName+"\n and the password = "+password+
                "\n This is an unsecured line don't share passwords";

    }

    @PostMapping("/students")
    public StudentResponseDTO addStudent(@RequestBody StudentDTO stu){
        Student student = getStudent(stu);
        Student stuResponse=repository.save(student);
        return studentResponse(stuResponse);
    }

    private StudentResponseDTO studentResponse(Student student){
        StudentResponseDTO studentResponseDTO=new StudentResponseDTO(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );

        return studentResponseDTO;
    }

    private Student getStudent(StudentDTO stu){
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




    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return repository.findAll();
    }

    @GetMapping("/search/{student-name}")
    public List<Student> findStudentsByName(
            @PathVariable(name = "student-name") String name
            ){
        return repository.findAllByFirstNameContaining(name);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/students/{id}")
    public void deleteStudent(
            @PathVariable(name="id") int id
    ){
        repository.deleteById(id);
    }

}
