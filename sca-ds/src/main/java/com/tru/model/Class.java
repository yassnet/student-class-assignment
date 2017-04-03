package com.tru.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by yassnet on 4/2/17.
 */

@Entity
@Table(name = "classes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Class implements Serializable {

    @Id
    @Column
    private String code;

    @Column
    private String title;

    @Column
    private String description;

    @OneToMany(mappedBy = "aClass", cascade = CascadeType.REMOVE)
    private List<StudentClass> students;

    public Class() {
    }

    public Class(String code, String title, String description) {
        this.code = code;
        this.title = title;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<StudentClass> getStudents() {
        return students;
    }

    public void setStudents(List<StudentClass> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Class aClass = (Class) o;

        return title != null ? title.equals(aClass.title) : aClass.title == null;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Class{" +
                "code=" + code +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}