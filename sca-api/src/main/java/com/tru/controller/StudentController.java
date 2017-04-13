package com.tru.controller;

import com.tru.exception.CoreException;
import com.tru.model.Student;
import com.tru.response.ResponseMessage;
import com.tru.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-03
 * @since 1.8
 */
@RestController
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> find(@RequestParam(value = "key", required = false) String key,
                                              @RequestParam(value = "firstName", required = false) String firstName,
                                              @RequestParam(value = "lastName", required = false) String lastName) {

        logger.debug("Getting students... key:[{}] firstName:[{}] lastName:[{}]", new Object[]{key, firstName, lastName});

        List<Student> students;

        try {
            if (!StringUtils.isEmpty(key)) students = studentService.findByKey(key);
            else if (!StringUtils.isEmpty(firstName)) students = studentService.findByFirstName(firstName);
            else if (!StringUtils.isEmpty(lastName)) students = studentService.findByLastName(lastName);
            else students = studentService.getAll();
        } catch (CoreException e) {
            logger.error("Core error key:[{}] firstName:[{}] lastName:[{}] e:", new Object[]{key, firstName, lastName, e});
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return students.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(students, HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {

        logger.debug("Getting Student... id:[{}]", id);

        Optional<Student> student;
        try {
            student = studentService.findById(id);
        } catch (CoreException e) {
            logger.error("Core error id:[{}] e:", id, e);
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return student.map(student1 -> new ResponseEntity<>(student1, HttpStatus.OK))
                .orElseGet(() -> {
                    logger.debug("Student not found... id:[{}]", id);
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Student student, UriComponentsBuilder ucb) {

        logger.debug("Saving Student... firstName:[{}] lastName:[{}]", student.getFirstName(), student.getLastName());

        try {
            studentService.save(student);
        } catch (CoreException e) {
            logger.error("Core error firstName:[{}] lastName:[{}] e:", new Object[]{student.getFirstName(), student.getLastName(), e});
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.debug("Student saved, firstName:[{}] lastName:[{}]", student.getFirstName(), student.getLastName());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Student student) {

        logger.debug("Updating Student... id:[{}]", id);

        Optional<Student> studentToUpdate;
        try {
            studentToUpdate = studentService.findById(id);

            if (!studentToUpdate.isPresent()) {
                logger.warn("Conflict updating Student, id:[{}]", id);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            studentToUpdate.get().setFirstName(student.getFirstName());
            studentToUpdate.get().setLastName(student.getLastName());

            studentService.update(studentToUpdate.get());
        } catch (CoreException e) {
            logger.error("Core error id:[{}] e:", id, e);
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.debug("Student updated, id:[{}] firstName:[{}] lastName:[{}]", new Object[]{id, student.getFirstName(),
                student.getLastName()});
        return new ResponseEntity<>(studentToUpdate.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> remove(@PathVariable("id") Integer id) {
        logger.debug("Removing Student... id:[{}]", id);

        try {
            Optional<Student> student = studentService.findById(id);
            if (!student.isPresent()) {
                logger.debug("Student not found... id:[{}]", id);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            studentService.remove(id);
        } catch (CoreException e) {
            logger.error("Core error id:[{}] e:", id, e);
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);

        }
        logger.debug("Student removed, id:[{}]", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/students", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeAll() {

        try {
            studentService.removeAll();
        } catch (CoreException e) {
            logger.error("Core error e:", e);
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        logger.debug("All students removed");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}