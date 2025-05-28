package com.desafio.professor.controller;

import com.desafio.professor.repository.ClassScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProfessorController {
    @Autowired
    private ClassScheduleRepository classScheduleRepository;

    @GetMapping("/professors/hours")
    public List<Object[]> getProfessorHours() {
        return classScheduleRepository.findTotalHoursByProfessor();
    }
}
