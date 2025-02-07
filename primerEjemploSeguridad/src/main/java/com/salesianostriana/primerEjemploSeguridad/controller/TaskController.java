package com.salesianostriana.primerEjemploSeguridad.controller;

import com.salesianostriana.primerEjemploSeguridad.model.Task;
import com.salesianostriana.primerEjemploSeguridad.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task/")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<Task> findAll() {
        return taskService.findAll();
    }

    @PostMapping
    public ResponseEntity<Task> add(@RequestBody Task nuevo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(taskService.add(nuevo));
    }

    @GetMapping("{id}")
    public Task findById(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @PutMapping("{id}")
    public Task edit(@RequestBody Task task, @PathVariable Long id) {
        return taskService.edit(task, id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
