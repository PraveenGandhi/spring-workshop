package com.learning.spring.workshop.dao;

import com.learning.spring.workshop.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDAOImpl implements IStudentDAO {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void createStudentTable() {
        String SQL = "CREATE TABLE IF NOT EXISTS Student(\n" +
                "   ID   INT NOT NULL AUTO_INCREMENT,\n" +
                "   NAME VARCHAR(20) NOT NULL,\n" +
                "   AGE  INT NOT NULL,\n" +
                "   PRIMARY KEY (ID)\n" +
                ");";

        jdbcTemplate.update(SQL);
    }

    public  StudentDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(String name, Integer age) {
        String SQL = "insert into Student (name, age) values (?, ?)";
        jdbcTemplate.update(SQL, name, age);
        System.out.println("Created Record Name = " + name + " Age = " + age);
    }

    public Student getStudent(Integer id) {
        String SQL = "select * from Student where id = ?";
        Student student = jdbcTemplate.queryForObject(SQL,
                new Object[]{id}, new StudentMapper());

        return student;
    }

    public List<Student> listStudents() {
        String SQL = "select * from Student";
        return jdbcTemplate.query(SQL, new StudentMapper());
    }

    public void delete(Integer id) {
        String SQL = "delete from Student where id = ?";
        jdbcTemplate.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id);
    }

    public void update(Integer id, Integer age) {
        String SQL = "update Student set age = ? where id = ?";
        jdbcTemplate.update(SQL, age, id);
        System.out.println("Updated Record with ID = " + id);
    }
}
