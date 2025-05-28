-- DEPARTMENTS
INSERT INTO department (id, name) VALUES (1, 'Computação'), (2, 'Matemática');

-- TITLES
INSERT INTO title (id, name, department_id, title_id) VALUES
(1, 'Doutor', 1, NULL),
(2, 'Mestre', 2, 1);

-- PROFESSORS
INSERT INTO professor (id, name) VALUES
(1, 'Carlos Silva'),
(2, 'Ana Souza');

-- BUILDINGS
INSERT INTO building (id, name) VALUES
(1, 'Bloco A'),
(2, 'Bloco B');

-- ROOMS
INSERT INTO room (id, name, building_id) VALUES
(1, 'Sala 101', 1),
(2, 'Sala 102', 1),
(3, 'Sala 201', 2);

-- SUBJECTS
INSERT INTO subject (id, code, name) VALUES
(1, 'CS101', 'Algoritmos'),
(2, 'CS102', 'Estruturas de Dados');

-- SUBJECT PREREQUISITE
INSERT INTO subject_prerequisite (id, subject_id, prerequisite_id) VALUES
(1, 2, 1);

-- CLASS_SCHEDULE
INSERT INTO class_schedule (id, name, room_id, day_of_week, start_time, end_time) VALUES
(1, 'Algoritmos - A', 1, 1, '08:00', '10:00'),
(2, 'Estruturas - B', 2, 3, '10:00', '12:00');

-- CLASS
INSERT INTO class (id, class_id, room_id, professor_id, day_of_week, start_time, end_time) VALUES
(1, NULL, 1, 1, 1, '08:00', '10:00'),
(2, 1, 2, 2, 3, '10:00', '12:00');
