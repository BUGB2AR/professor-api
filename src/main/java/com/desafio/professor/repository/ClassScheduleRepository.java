package com.desafio.professor.repository;

import com.desafio.professor.model.ClassSchedule;
import com.desafio.professor.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassScheduleRepository extends JpaRepository<ClassSchedule, Long> {
    @Query(value = "SELECT p.id AS professor_id, p.name AS professor_name, " +
            "SUM(EXTRACT(EPOCH FROM (cs.end_time - cs.start_time)) / 3600) AS total_hours " +
            "FROM class_schedule cs " +
            "JOIN class c ON cs.id = c.id " +
            "JOIN professor p ON c.professor_id = p.id " +
            "GROUP BY p.id, p.name", nativeQuery = true)
    List<Object[]> findTotalHoursByProfessor();

    List<ClassSchedule> findByRoomAndDayOfWeek(Room room, int dayOfWeek);
}
