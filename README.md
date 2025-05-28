# Desafio Técnico - Gestão de Professores e Horários

Este projeto tem como objetivo criar uma API para gerenciar professores, salas, departamentos, disciplinas e horários de aula em uma instituição de ensino.

## 🧩 Tecnologias Utilizadas

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- Lombok

## 📁 Estrutura da Aplicação

O sistema é composto por várias entidades, entre elas:

- **Professor**
- **Department**
- **Title**
- **Room**
- **Building**
- **Subject**
- **Class**
- **ClassSchedule**
- **SubjectPrerequisite**

Essas entidades estão relacionadas por meio de anotações JPA como `@ManyToOne`, `@OneToMany` e `@JoinColumn`, modelando o domínio educacional.

---

## 📌 Desafio

O desafio principal é implementar uma consulta que calcule o total de horas ministradas por cada professor, com base na duração das aulas associadas a ele e também salas com horários livres e ocupados.

### 🎯 Requisito

Calcular a carga horária total de cada professor com base nos horários registrados na tabela `class_schedule`.
Realizar a consulta de salas com horários livres e ocupados.

---

## 🧠 Consulta SQL Personalizada

Foi utilizada a anotação `@Query` com SQL nativo para calcular a soma das horas de aula ministradas por cada professor:

```java
@Query(value = """
    SELECT p.id AS professor_id, p.name AS professor_name,
           SUM(EXTRACT(EPOCH FROM (cs.end_time - cs.start_time)) / 3600) AS total_hours
    FROM class_schedule cs
    JOIN class c ON cs.id = c.id
    JOIN professor p ON c.professor_id = p.id
    GROUP BY p.id, p.name
    """, nativeQuery = true)
List<Object[]> findTotalHoursByProfessor();
