package com.tru.controller;

import com.tru.exception.CoreException;
import com.tru.model.Class;
import com.tru.response.ResponseMessage;
import com.tru.service.ClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
public class ClassController {

    private static final Logger logger = LoggerFactory.getLogger(ClassController.class);

    @Autowired
    private ClassService classService;

    public void setClassService(ClassService classService) {
        this.classService = classService;
    }

    @RequestMapping(value = "/classes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> find(@RequestParam(value = "key", required = false) String key,
                                            @RequestParam(value = "title", required = false) String title,
                                            @RequestParam(value = "description", required = false) String description) {

        logger.debug("Getting classes... key:[{}] title:[{}] description:[{}]", new Object[]{key, title, description});

        List<Class> classes;

        try {
            if (!StringUtils.isEmpty(key)) classes = classService.findByKey(key);
            else if (!StringUtils.isEmpty(title)) classes = classService.findByTitle(title);
            else if (!StringUtils.isEmpty(description)) classes = classService.findByDescription(description);
            else classes = classService.getAll();
        } catch (CoreException e) {
            logger.error("Core error key:[{}] title:[{}] description:[{}] e:", new Object[]{key, title, description, e});
            return new ResponseEntity<>(new ResponseMessage(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return classes.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(classes, HttpStatus.OK);
    }

    @RequestMapping(value = "/classes/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> get(@PathVariable("code") String code) {

        logger.debug("Getting Class... code:[{}]", code);

        Optional<Class> aClass = Optional.empty();
        try {
            aClass = classService.findById(code);
        } catch (CoreException e) {
            logger.error("Core error code:[{}] e:", code, e);
        }

        return aClass.map(class1 -> new ResponseEntity<>(class1, HttpStatus.OK))
                .orElseGet(() -> {
                    logger.debug("Class not found... code:[{}]", code);
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
    }

    @RequestMapping(value = "/classes", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Class aClass, UriComponentsBuilder ucb) {

        logger.debug("Saving Class... code:[{}] title:[{}]", aClass.getCode(), aClass.getTitle());

        try {
            classService.save(aClass);
        } catch (CoreException e) {
            logger.error("Core error code:[{}] title:[{}] e:", new Object[]{aClass.getCode(), aClass.getTitle(), e});
        }
        logger.debug("Class saved, code:[{}] title:[{}]", aClass.getCode(), aClass.getTitle());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucb.path("/class/{code}").buildAndExpand(aClass.getCode()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/classes/{code}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("code") String code, @RequestBody Class aClass) {
        logger.debug("Updating Class... code:[{}] title:[{}]", aClass.getCode(), aClass.getTitle());

        Optional<Class> classToUpdate = Optional.empty();
        try {
            classToUpdate = classService.findById(code);

            if (!classToUpdate.isPresent()) {
                logger.warn("Conflict updating Class, code:[{}] title:[{}]", aClass.getCode(), aClass.getTitle());
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            classToUpdate.get().setTitle(aClass.getTitle());
            classToUpdate.get().setDescription(aClass.getDescription());

            classService.update(classToUpdate.get());
        } catch (CoreException e) {
            logger.error("Core error code:[{}] title:[{}] e:", new Object[]{aClass.getCode(), aClass.getTitle(), e});
        }
        logger.debug("Class updated, code:[{}] title:[{}]", aClass.getCode(), aClass.getTitle());
        return new ResponseEntity<>(classToUpdate.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/classes/{code}", method = RequestMethod.DELETE)
    public ResponseEntity<?> remove(@PathVariable("code") String code) {
        logger.debug("Removing Class... code:[{}]", code);

        try {
            Optional<Class> aClass = classService.findById(code);
            if (!aClass.isPresent()) {
                logger.debug("Class not found... code:[{}]", code);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            classService.remove(code);
        } catch (CoreException e) {
            logger.error("Core error code:[{}] e:", code, e);
        }
        logger.debug("Class removed, code:[{}]", code);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/classes", method = RequestMethod.DELETE)
    public ResponseEntity<?> removeAll() {

        try {
            classService.removeAll();
        } catch (CoreException e) {
            logger.error("Core error e:", e);
        }
        logger.debug("All classes removed");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}