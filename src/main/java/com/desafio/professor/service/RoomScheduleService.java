package com.desafio.professor.service;

import com.desafio.professor.dto.RoomScheduleDTO;
import com.desafio.professor.model.ClassSchedule;
import com.desafio.professor.model.Room;
import com.desafio.professor.repository.ClassScheduleRepository;
import com.desafio.professor.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RoomScheduleService {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ClassScheduleRepository classScheduleRepository;

    public List<RoomScheduleDTO> getRoomSchedules() {
        List<Room> rooms = roomRepository.findAll();
        List<RoomScheduleDTO> result = new ArrayList<>();

        List<Integer> daysOfWeek = Arrays.asList(1, 2, 3, 4, 5);
        int slotMinutes = 30;
        LocalTime startDay = LocalTime.of(7, 0);
        LocalTime endDay = LocalTime.of(22, 0);

        for (Room room : rooms) {
            for (int day : daysOfWeek) {
                LocalTime current = startDay;
                while (current.isBefore(endDay)) {
                    LocalTime slotStart = current;
                    LocalTime slotEnd = current.plusMinutes(slotMinutes);
                    boolean occupied = isSlotOccupied(room, day, slotStart, slotEnd);
                    result.add(new RoomScheduleDTO(room, day, slotStart, slotEnd, occupied ? "occupied" : "free"));
                    current = slotEnd;
                }
            }
        }
        return result;
    }

    private boolean isSlotOccupied(Room room, int day, LocalTime slotStart, LocalTime slotEnd) {
        List<ClassSchedule> schedules = classScheduleRepository.findByRoomAndDayOfWeek(room, day);
        for (ClassSchedule schedule : schedules) {
            if (isOverlap(schedule.getStartTime(), schedule.getEndTime(), slotStart, slotEnd)) {
                return true;
            }
        }
        return false;
    }

    private boolean isOverlap(LocalTime start1, LocalTime end1, LocalTime start2, LocalTime end2) {
        return start1.isBefore(end2) && end1.isAfter(start2);
    }
}
