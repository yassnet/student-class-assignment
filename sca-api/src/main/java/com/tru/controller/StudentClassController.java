package com.tru.controller;

import com.tru.exception.CoreException;
import com.tru.model.Class;
import com.tru.model.Student;
import com.tru.model.StudentClass;
import com.tru.model.StudentClassPK;
import com.tru.response.ResponseMessage;
import com.tru.service.ClassService;
import com.tru.service.StudentClassService;
import com.tru.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-03
 * @since 1.8
 */
@RestController
public class StudentClassController {

    private static final Logger logger = LoggerFactory.getLogger(StudentClassController.class);

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
    public ResponseEntity<?> getAll() {

        logger.debug("Getting assignments...");
        List<StudentClass> classes;
        try {
            classes = studentClassService.getAll();
        } catch (CoreException e) {
            logger.error("Core error e:", e);
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return classes.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(classes, HttpStatus.OK);
    }

    @RequestMapping(value = "/classes/{code}/students", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> get(@PathVariable("code") String code) {

        logger.debug("Getting students of Class... code:[{}]", code);
        List<StudentClass> studentClasses;
        try {
            studentClasses = studentClassService.findByClass(code);
        } catch (CoreException e) {
            logger.error("Core error code:[{}] e:", code, e);
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return studentClasses.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(studentClasses.stream().map(studentClass ->
                        studentClass.getStudentClassPK().getStudent())
                        .collect(Collectors.toList()),
                        HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{id}/classes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {

        logger.debug("Getting classes of Student... id:[{}]", id);

        List<StudentClass> studentClasses;
        try {
            studentClasses = studentClassService.findByStudent(id);
        } catch (CoreException e) {
            logger.error("Core error id:[{}] e:", id, e);
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return studentClasses.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(studentClasses.stream().map(studentClass ->
                        studentClass.getStudentClassPK().getaClass())
                        .collect(Collectors.toList()),
                        HttpStatus.OK);
    }

    @RequestMapping(value = {"/classes/{code}/students/{id}", "/students/{id}/classes/{code}"}, method = RequestMethod.PUT)
    public ResponseEntity<?> save(@PathVariable("code") String code, @PathVariable("id") Integer id,
                                     UriComponentsBuilder ucb) {

        logger.debug("Saving assignment... class:[{}] student:[{}]", code, id);
        Optional<Student> student;
        Optional<Class> aClass;
        try {
            student = studentService.findById(id);
            aClass = classService.findById(code);
            if (!student.isPresent() || !aClass.isPresent()) {
                logger.warn("Conflict saving Assignment, class:[{}] student:[{}]", code, id);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            studentClassService.save(new StudentClass(new StudentClassPK(student.get(), aClass.get())));
        } catch (CoreException e) {
            logger.error("Core error class:[{}] student:[{}] e:", new Object[]{code, id, e});
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.debug("Assignment saved, class:[{}] student:[{}]", code, id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/classes/{code}/students/{id}", "/students/{id}/classes/{code}"}, method = RequestMethod.DELETE)
    public ResponseEntity<?> remove(@PathVariable("code") String code, @PathVariable("id") Integer id) {

        logger.debug("Removing assignment... class:[{}] student:[{}]", code, id);

        try {
            Optional<Student> student = studentService.findById(id);
            Optional<Class> aClass = classService.findById(code);
            if (!student.isPresent() || !aClass.isPresent()) {
                logger.debug("Assignment not found... class:[{}] student:[{}]", code, id);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            studentClassService.remove(id, code);
        } catch (CoreException e) {
            logger.error("Core error class:[{}] student:[{}] e:", new Object[]{code, id, e});
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.debug("Assignment removed, id:[{}]", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/assignments", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeAll() {

        try {
            studentClassService.removeAll();
        } catch (CoreException e) {
            logger.error("Core error e:", e);
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.debug("All assignments removed");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}