package com.restapi.application.student;

import com.restapi.application.order.Order;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
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
    public StudentResponseDTO addStudent(
            @Valid @RequestBody StudentDTO stu){
        return studentService.saveStudent(stu);
    }



    @GetMapping("/students")
    public List<StudentResponseDTO> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/search/{student-name}")
    public List<StudentResponseDTO> findStudentsByName(
            @PathVariable(name = "student-name") String name
            ){
        return studentService.findStudentsByName(name);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/students/{id}")
    public void deleteStudent(
            @PathVariable(name="id") int id
    ){
        studentService.deleteStudent(id);
    }

    @GetMapping("/students/{id}")
    public StudentResponseDTO getStudentById(@PathVariable(name="id") int id){
        return studentService.getStudentById(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException
            (MethodArgumentNotValidException exp){
        Map<String,String> errorMap=new HashMap<String,String>();
        exp.getBindingResult().getAllErrors().
                forEach(error->{
                    var fieldName=((FieldError) error).getField();
                    var errorMessage=error.getDefaultMessage();
                    errorMap.put(fieldName,errorMessage);
                });
        return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
    }


}
