package com.salesianostriana.primerEjemploSeguridad.service;

import com.salesianostriana.primerEjemploSeguridad.model.Task;
import com.salesianostriana.primerEjemploSeguridad.repos.TaskRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepo taskRepo;

    public List<Task> findAll() {
        List<Task> taskList = taskRepo.findAll();

        if(taskList.isEmpty()) {
            throw new EntityNotFoundException("No se encontraron tasks.");
        }
        return taskList;
    }

    public Task add(Task nuevo) {
        return taskRepo.save(Task.builder()
                .titulo(nuevo.getTitulo())
                .build());
    }

    public Task findById(Long id) {
        Optional<Task> taskOpt = taskRepo.findById(id);

        if(taskOpt.isEmpty()) {
            throw new EntityNotFoundException("No se encontró la task con id: " + id);
        }
        return taskOpt.get();
    }

    public Task edit(Task task, Long id) {
        return taskRepo.findById(id)
                .map(old -> {
                    old.setTitulo(task.getTitulo());
                    return taskRepo.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la task con id: " + id));
    }

    public void delete(Long id) {
        taskRepo.deleteById(id);
    }

}
