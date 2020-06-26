package com.github.nut077.kanban.service;

import com.github.nut077.kanban.dto.ProjectDto;
import com.github.nut077.kanban.dto.mapper.ProjectMapper;
import com.github.nut077.kanban.entity.Project;
import com.github.nut077.kanban.exception.BadRequestException;
import com.github.nut077.kanban.exception.NotFoundException;
import com.github.nut077.kanban.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {

  private final ProjectRepository projectRepository;
  private final ProjectMapper mapper;

  public List<ProjectDto> findAll() {
    return mapper.mapToListDto(projectRepository.findAll());
  }

  public ProjectDto findByProjectIdentifier(String projectIdentifier) {
    Optional<Project> optionalProject = projectRepository.findByProjectIdentifier(projectIdentifier);
    if (optionalProject.isPresent()) {
      return mapper.mapToDto(optionalProject.get());
    }
    throw new NotFoundException("Project identifier: " + projectIdentifier + " does not exists");
  }

  private Project fetchProjectByProjectIdentifier(String projectIdentifier) {
    Optional<Project> optionalProject = projectRepository.findByProjectIdentifier(projectIdentifier);
    if (optionalProject.isPresent()) {
      return optionalProject.get();
    }
    throw new NotFoundException("Project identifier: " + projectIdentifier + " does not exists");
  }

  public ProjectDto create(ProjectDto dto) {
    Project project = mapper.mapToEntity(dto);
    Optional<Project> optionalProject = projectRepository.findByProjectIdentifier(project.getProjectIdentifier());
    if (optionalProject.isEmpty()) {
      return mapper.mapToDto(projectRepository.save(project));
    }
    throw new BadRequestException("Project identifier " + dto.getProjectIdentifier().toUpperCase() + " already exists");
  }

  public ProjectDto update(String projectIdentifier, ProjectDto dto) {
    Project project = fetchProjectByProjectIdentifier(projectIdentifier);
    return mapper.mapToDto(projectRepository.save(mapper.mapToEntity(dto, project)));
  }

  public void delete(String projectIdentifier) {
    Project project = fetchProjectByProjectIdentifier(projectIdentifier);
    projectRepository.delete(project);
  }
}
