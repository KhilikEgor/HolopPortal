package com.example.holopportal.controllers;

import javax.inject.Inject;
import javax.websocket.server.PathParam;

import com.example.holopportal.screenplay.entities.ScreenPlayElement;
import com.example.holopportal.screenplay.services.ScreenPlayService;
import com.example.holopportal.tasks.services.TasksService;
import com.example.holopportal.user.services.UserService;
import org.apache.coyote.Response;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TasksController {
    @Inject
    UserService userService;

    @Inject
    TasksService tasksService;

    @Inject
    ScreenPlayService screenPlayService;

    @GetMapping("/tasks/new")
    public String greeting(Model model) {
        model.addAttribute("currentUser", userService.getCurrentUser().get());
        model.addAttribute("workers", userService.getAllWorkers());
        model.addAttribute("taskTypes", tasksService.getAllTaskTypes());
        model.addAttribute("screenPlayElements", screenPlayService.getAllScreenPlays());
        return "newtask";
    }

    @GetMapping("/tasks")
    public String getTasks(Model model) {
        model.addAttribute("currentUser", userService.getCurrentUser().get());
        model.addAttribute("tasks", tasksService.getAllTasks());
        return "tasks";
    }


}