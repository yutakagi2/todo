package com.example.todo.repository;

import com.example.todo.model.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void testSaveAndFind() {
        Task task = new Task();
        task.setTitle("Repository Test");

        taskRepository.save(task);

        List<Task> tasks = taskRepository.findAll();
        assertThat(tasks).hasSize(1);
        assertThat(tasks.get(0).getTitle()).isEqualTo("Repository Test");
    }

    @Test
    void testDelete() {
        Task task = new Task();
        task.setTitle("To be deleted");

        Task saved = taskRepository.save(task);
        taskRepository.deleteById(saved.getId());

        assertThat(taskRepository.findById(saved.getId())).isEmpty();
    }
}
