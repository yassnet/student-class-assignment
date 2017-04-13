package com.tru.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by yassnet on 4/11/17.
 */

@Embeddable
public class StudentClassPK implements Serializable {

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "class_code")
    private Class aClass;

    public StudentClassPK() {
    }

    public StudentClassPK(Student student, Class aClass) {
        this.student = student;
        this.aClass = aClass;
    }

    public StudentClassPK(Integer id, String code) {
        this.student = new Student(id, null, null);
        this.aClass = new Class(code, null, null);
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

        StudentClassPK that = (StudentClassPK) o;

        if (!student.getId().equals(that.student.getId())) return false;
        return aClass.getCode().equals(that.aClass.getCode());
    }

    @Override
    public int hashCode() {
        int result = student != null ? student.hashCode() : 0;
        result = 31 * result + (aClass != null ? aClass.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StudentClassPK{" +
                "student=" + student +
                ", aClass=" + aClass +
                '}';
    }
}
