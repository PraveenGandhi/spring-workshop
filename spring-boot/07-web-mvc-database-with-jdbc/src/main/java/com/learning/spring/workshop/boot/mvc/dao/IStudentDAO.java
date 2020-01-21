package com.learning.spring.workshop.boot.mvc.dao;

import com.learning.spring.workshop.boot.mvc.model.Student;

import java.util.List;

public interface IStudentDAO {

    long save(Student student);

    long update(Student student);

    List<Student> getAll();

    Student get(Long id);

    void delete(long id);
}
