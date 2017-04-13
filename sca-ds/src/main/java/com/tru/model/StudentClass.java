package com.tru.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Yassir Aguila
 * @version $Revision: 1.0 $ $Date: 2017-04-02
 * @since 1.8
 */
@Entity
@Table(name = "students_classes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StudentClass implements Serializable {
    @EmbeddedId
    private StudentClassPK studentClassPK;

    public StudentClass() {
    }

    public StudentClass(StudentClassPK studentClassPK) {
        this.studentClassPK = studentClassPK;
    }

    public StudentClassPK getStudentClassPK() {
        return studentClassPK;
    }

    public void setStudentClassPK(StudentClassPK studentClassPK) {
        this.studentClassPK = studentClassPK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentClass that = (StudentClass) o;

        return studentClassPK != null ? studentClassPK.equals(that.studentClassPK) : that.studentClassPK == null;
    }

    @Override
    public int hashCode() {
        return studentClassPK != null ? studentClassPK.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "StudentClass{" +
                "studentClassPK=" + studentClassPK +
                '}';
    }
}
