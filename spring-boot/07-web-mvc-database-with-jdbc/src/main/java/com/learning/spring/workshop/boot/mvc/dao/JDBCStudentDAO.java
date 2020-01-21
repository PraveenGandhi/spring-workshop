package com.learning.spring.workshop.boot.mvc.dao;

import com.learning.spring.workshop.boot.mvc.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JDBCStudentDAO implements IStudentDAO {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public JDBCStudentDAO(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long save(Student student) {
        KeyHolder generatedId = new GeneratedKeyHolder();
        jdbcTemplate.update("insert into student values(default, :name, :age)",
                new BeanPropertySqlParameterSource(student), generatedId);
        return (Integer) generatedId.getKeys().get("ID");
    }

    @Override
    public long update(Student student) {
        return jdbcTemplate.update("update student set name = :name, age= :age where id = :id",
                new BeanPropertySqlParameterSource(student));
    }

    @Override
    public List<Student> getAll() {
        return jdbcTemplate.query("select * from student", new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public Student get(Long id) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);
        return jdbcTemplate.queryForObject("select * from student where id = :id", parameters,
                new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public void delete(long id) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);
        jdbcTemplate.update("delete from student where id = :id", parameters);
    }
}
