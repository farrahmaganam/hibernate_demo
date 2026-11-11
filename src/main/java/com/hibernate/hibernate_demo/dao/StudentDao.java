package com.hibernate.hibernate_demo.dao;

import com.hibernate.hibernate_demo.entity.Student;
import java.util.List;

public interface StudentDao {

    void save(Student theStudent);
    Student findbyId(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void update(Student theStudent);
    void delete(Integer id);
    int deleteAll();

}