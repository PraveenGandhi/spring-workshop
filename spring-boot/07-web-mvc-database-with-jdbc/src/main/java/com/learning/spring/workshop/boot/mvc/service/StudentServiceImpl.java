package com.learning.spring.workshop.boot.mvc.service;

import com.learning.spring.workshop.boot.mvc.dao.IStudentDAO;
import com.learning.spring.workshop.boot.mvc.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    private final IStudentDAO studentDAO;

    public StudentServiceImpl(IStudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public long save(Student student) {
        return studentDAO.save(student);
    }

    @Override
    public long update(Student student) {
        return studentDAO.update(student);
    }

    @Override
    public List<Student> getAll() {
        return studentDAO.getAll();
    }

    @Override
    public Student get(Long id) {
        return studentDAO.get(id);
    }

    @Override
    public void delete(long id) {
        studentDAO.delete(id);
    }
}
