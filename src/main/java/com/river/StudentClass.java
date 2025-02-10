package com.river;

import jakarta.persistence.*;

@Entity
@Table(name = "student_class")
public class StudentClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String className;

    private int classSize;

    @Transient //This field will not be persisted
    private int ignoreClassField;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassSize() {
        return classSize;
    }

    public void setClassSize(int classSize) {
        this.classSize = classSize;
    }

    public int getIgnoreClassField() {
        return ignoreClassField;
    }

    public void setIgnoreClassField(int ignoreClassField) {
        this.ignoreClassField = ignoreClassField;
    }

    @Override
    public String toString() {
        return "StudentClass{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", classSize=" + classSize +
                '}';
    }
}
