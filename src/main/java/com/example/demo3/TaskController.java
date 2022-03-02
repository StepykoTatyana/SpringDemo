package com.example.demo3;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class TaskController {

    List<Task> taskList = List.of(
            new Task(1, "task1", "A first test task", false),
            new Task(2, "task2", "A second test task", true)
    );

    @GetMapping("/test")
    public int returnOne() {
        return 1;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskList;
    }


    @GetMapping("/tasks/{id}")
    public ResponseEntity<?> getTasks(@PathVariable int id) {
        try {
            return new ResponseEntity<>(taskList.get(id - 1), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            System.out.println("Wrong id");
            return new ResponseEntity<>("Wrong id", HttpStatus.NOT_FOUND);
        }
    }

    List<Student> students = List.of(
            new Student(84, "Alice"),
            new Student(99, "Kate"),
            new Student(55, "Someone")
    );

    @GetMapping("/students")
    public List<Student> getList() {
        return students;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }


    Cinema cinemaList =
            new Cinema(9, 9);

    @GetMapping("/seats")
    public Cinema getCinemaList() {
        return cinemaList;
    }

}
