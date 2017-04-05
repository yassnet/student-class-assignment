package com.tru.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by yassnet on 4/2/17.
 */

@Entity
@Table(name = "students_classes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StudentClass implements Serializable {
    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_id")
    private Student student;

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "class_code")
    private Class aClass;

    public StudentClass() {
    }

    public StudentClass(Student student, Class aClass) {
        this.student = student;
        this.aClass = aClass;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentClass that = (StudentClass) o;

        if (!student.equals(that.student)) return false;
        return aClass.equals(that.aClass);
    }

    @Override
    public int hashCode() {
        int result = student.hashCode();
        result = 31 * result + aClass.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "StudentClass{" +
                "student=" + student +
                ", aClass=" + aClass +
                '}';
    }
}
