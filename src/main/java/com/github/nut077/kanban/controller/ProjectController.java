package com.github.nut077.kanban.controller;

import com.github.nut077.kanban.dto.ProjectDto;
import com.github.nut077.kanban.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.github.nut077.kanban.dto.response.SuccessResponse.builder;
import static org.springframework.http.ResponseEntity.ok;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/project")
public class ProjectController {

  private final ProjectService projectService;

  @GetMapping
  public ResponseEntity<?> findAllProject() {
    return ok(builder(projectService.findAll()).build());
  }

  @GetMapping("/{projectIdentifier}")
  public ResponseEntity<?> findProject(@PathVariable String projectIdentifier) {
    logProjectIdentifier(projectIdentifier);
    return ok(builder(projectService.findByProjectIdentifier(projectIdentifier)).build());
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody ProjectDto dto) {
    return ok(builder(projectService.create(dto)).build());
  }

  @PutMapping("/{projectIdentifier}")
  public ResponseEntity<?> update(@PathVariable String projectIdentifier, @RequestBody ProjectDto dto) {
    logProjectIdentifier(projectIdentifier);
    return ok(builder(projectService.update(projectIdentifier, dto)).build());
  }

  @DeleteMapping("/{projectIdentifier}")
  public ResponseEntity<?> delete(@PathVariable String projectIdentifier) {
    logProjectIdentifier(projectIdentifier);
    projectService.delete(projectIdentifier);
    return ok(builder("Project with project identifier: " + projectIdentifier + " was deleted").build());
  }

  private void logProjectIdentifier(String projectIdentifier) {
    log.info("ProjectController::update projectIdentifier -->> {}", projectIdentifier);
  }
}
