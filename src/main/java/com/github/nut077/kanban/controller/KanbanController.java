package com.github.nut077.kanban.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KanbanController {

  @GetMapping("/")
  public String hello() {
    return "66";
  }
}
