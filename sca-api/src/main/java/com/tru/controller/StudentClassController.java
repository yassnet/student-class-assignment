package com.tru.controller;

import com.tru.model.Class;
import com.tru.model.Student;
import com.tru.model.StudentClass;
import com.tru.service.ClassService;
import com.tru.service.StudentClassService;
import com.tru.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by yassnet on 4/3/17.
 */

@RestController
public class StudentClassController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassService classService;

    @Autowired
    private StudentClassService studentClassService;


    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setClassService(ClassService classService) {
        this.classService = classService;
    }

    public void setStudentClassService(StudentClassService studentClassService) {
        this.studentClassService = studentClassService;
    }

    @RequestMapping(value = "/assignments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentClass>> getAll() {
        List<StudentClass> classes = studentClassService.getAll();
        return classes.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(classes, HttpStatus.OK);
    }

    @RequestMapping(value = "/class/{code}/students", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> get(@PathVariable("code") String code) {

        List<StudentClass> studentClasses = studentClassService.findByClass(code);
        return studentClasses.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(studentClasses.stream().map(StudentClass::getStudent)
                        .collect(Collectors.toList()),
                        HttpStatus.OK);
    }

    @RequestMapping(value = "/student/{id}/classes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Class>> get(@PathVariable("id") Integer id) {

        List<StudentClass> studentClasses = studentClassService.findByStudent(id);
        return studentClasses.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(studentClasses.stream().map(StudentClass::getaClass)
                                                            .collect(Collectors.toList()),
                        HttpStatus.OK);
    }

    @RequestMapping(value = "/class/{code}/student/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> save(@PathVariable("code") String code, @PathVariable("id") Integer id,
                                     UriComponentsBuilder ucb) {

        Optional<Student> student = studentService.findById(id);
        Optional<Class> aClass = classService.findById(code);
        if (!student.isPresent() || !   aClass.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        studentClassService.save(new StudentClass(student.get(), aClass.get()));

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucb.path("/student/{id}/classes").buildAndExpand(student.get().getId()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/student/{id}/class/{code}", method = RequestMethod.PUT)
    public ResponseEntity<Void> save(@PathVariable("id") Integer id, @PathVariable("code") String code,
                                     UriComponentsBuilder ucb) {

        Optional<Student> student = studentService.findById(id);
        Optional<Class> aClass = classService.findById(code);
        if (!student.isPresent() || !aClass.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        studentClassService.save(new StudentClass(student.get(), aClass.get()));

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucb.path("/class/{code}/students").buildAndExpand(aClass.get().getCode()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @RequestMapping(value = {"/class/{code}/student/{id}", "/student/{id}/class/{code}"}, method = RequestMethod.DELETE)
    public ResponseEntity<Class> remove(@PathVariable("code") String code, @PathVariable("id") Integer id) {

        Optional<Class> aClass = classService.findById(code);
        if (!aClass.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        studentClassService.remove(id, code);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/assignments", method = RequestMethod.DELETE)
    public ResponseEntity<Class> removeAll() {

        studentClassService.removeAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}