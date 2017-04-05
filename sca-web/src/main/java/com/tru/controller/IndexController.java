package com.tru.controller;

import com.tru.service.ClassService;
import com.tru.service.StudentClassService;
import com.tru.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * Created by yassnet on 4/3/17.
 */

@Controller
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(locale);

        model.addAttribute("serverTime", ZonedDateTime.now().format(formatter));

        model.addAttribute("students", studentService.getAll());

        model.addAttribute("classes", classService.getAll());

        model.addAttribute("assignments", studentClassService.getAll());

        return "index";
    }
}