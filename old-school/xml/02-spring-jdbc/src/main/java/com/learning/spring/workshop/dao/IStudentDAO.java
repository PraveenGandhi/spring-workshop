package com.learning.spring.workshop.dao;

import com.learning.spring.workshop.domain.Student;

import java.util.List;

public interface IStudentDAO {
    void createStudentTable();

    void create(String name, Integer age);

    Student getStudent(Integer id);

    List<Student> listStudents();

    void delete(Integer id);

    void update(Integer id, Integer age);
}
