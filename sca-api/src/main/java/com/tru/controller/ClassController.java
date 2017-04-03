package com.tru.controller;

import com.tru.model.Class;
import com.tru.service.ClassService;
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
 * Created by yassnet on 4/3/17.
 */

@RestController
public class ClassController {

    @Autowired
    private ClassService classService;

    public void setClassService(ClassService classService) {
        this.classService = classService;
    }

	@RequestMapping(value = "/classes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Class>> find(@RequestParam(value = "key", required = false) String key,
											  @RequestParam(value = "title", required = false) String title,
											  @RequestParam(value = "description", required = false) String description) {
		List<Class> classes;

		if (!StringUtils.isEmpty(key)) classes = classService.findByKey(key);
		else if (!StringUtils.isEmpty(title)) classes = classService.findByTitle(title);
		else if (!StringUtils.isEmpty(description)) classes = classService.findByDescription(description);
		else classes = classService.getAll();

		return classes.isEmpty()? new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                                  new ResponseEntity<>(classes, HttpStatus.OK);
	}

    @RequestMapping(value = "/class/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Class> get(@PathVariable("code") String code) {

        Optional<Class> aClass = classService.findById(code);
        return aClass.map(class1 -> new ResponseEntity<>(class1, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/class/new", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Class aClass, UriComponentsBuilder ucb) {

        if (classService.exists(aClass)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        classService.save(aClass);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucb.path("/class/{code}").buildAndExpand(aClass.getCode()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/class/{code}", method = RequestMethod.PUT)
   	public ResponseEntity<Class> update(@PathVariable("code") String code, @RequestBody Class aClass) {

   		Optional<Class> classToUpdate = classService.findById(code);

   		if (!classToUpdate.isPresent()) {
   			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   		}

        classToUpdate.get().setTitle(aClass.getTitle());
        classToUpdate.get().setDescription(aClass.getDescription());

   		classService.update(classToUpdate.get());

   		return new ResponseEntity<>(classToUpdate.get(), HttpStatus.OK);
   	}

   	@RequestMapping(value = "/class/{code}", method = RequestMethod.DELETE)
   	public ResponseEntity<Class> remove(@PathVariable("code") String code) {

   		Optional<Class> aClass = classService.findById(code);
   		if (!aClass.isPresent()) {
   			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   		}

   		classService.remove(code);
   		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   	}

   	@RequestMapping(value = "/classes", method = RequestMethod.DELETE)
   	public ResponseEntity<Class> removeAll() {

   		classService.removeAll();

   		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   	}
}