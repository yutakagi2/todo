package com.example.todo.controller;

import com.example.todo.model.Task;
import com.example.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // フロントエンドとの接続許可
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    // 一覧取得
    @GetMapping
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    // 新規作成
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    // 更新
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updated) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setTitle(updated.getTitle());
        task.setCompleted(updated.isCompleted());
        return taskRepository.save(task);
    }

    // 削除
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}