package com.example.todo;

import com.example.todo.model.Task;
import com.example.todo.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class TodoApplicationTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void testTaskFlow() {
        Task task = new Task();
        task.setTitle("Integration Test");

        Task saved = taskRepository.save(task);
        assertThat(saved.getId()).isNotNull();

        List<Task> tasks = taskRepository.findAll();
        assertThat(tasks).isNotEmpty();
        assertThat(tasks.get(0).getTitle()).isEqualTo("Integration Test");
    }
}
