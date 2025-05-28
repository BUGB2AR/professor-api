package com.desafio.professor.model;

import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class clazz;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    private int dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
}