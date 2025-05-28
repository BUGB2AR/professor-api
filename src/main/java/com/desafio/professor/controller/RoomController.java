package com.desafio.professor.controller;


import com.desafio.professor.dto.RoomScheduleDTO;
import com.desafio.professor.service.RoomScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    @Autowired
    private RoomScheduleService roomScheduleService;

    @GetMapping("/schedule")
    public List<RoomScheduleDTO> getRoomSchedules() {
        return roomScheduleService.getRoomSchedules();
    }
}
