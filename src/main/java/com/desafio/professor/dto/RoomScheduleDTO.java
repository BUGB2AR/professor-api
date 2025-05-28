package com.desafio.professor.dto;

import com.desafio.professor.model.Room;
import lombok.Data;

import java.time.LocalTime;


@Data
public class RoomScheduleDTO {
    private Long roomId;
    private String roomName;
    private Long buildingId;
    private String buildingName;
    private int dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private String status;

    public RoomScheduleDTO() {
    }

    public RoomScheduleDTO(Long roomId, String roomName, Long buildingId, String buildingName,
                           int dayOfWeek, LocalTime startTime, LocalTime endTime, String status) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.buildingId = buildingId;
        this.buildingName = buildingName;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public RoomScheduleDTO(Room room, int day, LocalTime slotStart, LocalTime slotEnd, String status) {
        this.roomId = room.getId();
        this.roomName = room.getName();
        this.buildingId = room.getBuilding().getId();
        this.buildingName = room.getBuilding().getName();
        this.dayOfWeek = day;
        this.startTime = slotStart;
        this.endTime = slotEnd;
        this.status = status;
    }

}

