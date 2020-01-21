package com.learning.spring.workshop.boot.jdbc;

import com.learning.spring.workshop.boot.jdbc.domain.Student;
import com.learning.spring.workshop.boot.jdbc.repository.IStudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcProperties;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringBootJDBCApplication implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(SpringBootJDBCApplication.class);

    private final IStudentRepository studentRepository;

    public SpringBootJDBCApplication(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJDBCApplication.class, args);
    }

    @Override
    public void run(String... args) {

        String names = String.join("\n", applicationContext.getBeanDefinitionNames());
        logger.info("Beans Configured\n" + names);

        JdbcProperties jdbcProperties = applicationContext.getBean(JdbcProperties.class);
        logger.info(jdbcProperties.toString());

        logger.info("------Records Creation--------");
        studentRepository.create("Zara", 11);
        studentRepository.create("Nuha", 2);
        studentRepository.create("Ayan", 15);

        logger.info("------Listing Multiple Records--------");
        List<Student> students = studentRepository.listStudents();

        for (Student record : students) {
            logger.info("ID : " + record.getId() +
                    ", Name : " + record.getName() +
                    ", Age : " + record.getAge());
        }

        logger.info("----Updating Record with ID = 2 -----");
        studentRepository.update(2, 20);

        logger.info("----Listing Record with ID = 2 -----");
        Student student = studentRepository.getStudent(2);
        logger.info("ID : " + student.getId() +
                ", Name : " + student.getName() +
                ", Age : " + student.getAge());
    }

}
