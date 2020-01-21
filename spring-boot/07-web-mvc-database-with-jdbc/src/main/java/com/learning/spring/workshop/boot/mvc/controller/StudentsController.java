package com.learning.spring.workshop.boot.mvc.controller;

import com.learning.spring.workshop.boot.mvc.model.Student;
import com.learning.spring.workshop.boot.mvc.service.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentsController {

    private final IStudentService studentService;

    public StudentsController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String list(ModelMap modelMap) {
        modelMap.addAttribute("students", studentService.getAll());
        return "list";
    }

    @GetMapping("/save")
    public String save(Student student) {
        return "form";
    }

    @PostMapping("/save")
    public String save(@Valid Student student, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }
        studentService.save(student);
        return "redirect:";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, ModelMap modelMap) {
        modelMap.addAttribute("student", studentService.get(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid Student student, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "edit";
        }
        studentService.update(student);
        return "redirect:";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Student student = studentService.get(id);
        if (student == null) {
            throw new IllegalArgumentException("Invalid student Id:" + id);
        }

        studentService.delete(id);
        model.addAttribute("students", studentService.getAll());
        return "list";
    }
}
