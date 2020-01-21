package com.learning.spring.workshop.boot.jdbc.repository;


import com.learning.spring.workshop.boot.jdbc.domain.Student;

import java.util.List;

public interface IStudentRepository {

    void create(String name, Integer age);

    Student getStudent(Integer id);

    List<Student> listStudents();

    void delete(Integer id);

    void update(Integer id, Integer age);
}
