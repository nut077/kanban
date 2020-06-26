package com.github.nut077.kanban.dto.mapper;

import com.github.nut077.kanban.dto.ProjectDto;
import com.github.nut077.kanban.entity.Project;
import org.mapstruct.*;

import java.util.Collection;
import java.util.List;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.isTrue;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProjectMapper extends BaseMapper<Project, ProjectDto> {

  List<ProjectDto> mapToListDto(Collection<Project> entity);

  @Mappings({
    @Mapping(target = "startDate", dateFormat = "dd-MM-yyyy"),
    @Mapping(target = "endDate", dateFormat = "dd-MM-yyyy")
  })
  Project mapToEntity(ProjectDto dto, @MappingTarget Project entity);

  @Override
  @Mappings({
    @Mapping(target = "startDate", dateFormat = "dd-MM-yyyy"),
    @Mapping(target = "endDate", dateFormat = "dd-MM-yyyy")
  })
  ProjectDto mapToDto(Project entity);

  @BeforeMapping
  default void validate(ProjectDto dto) {
    hasText(dto.getProjectName(), () -> "Project name is required");
    hasText(dto.getProjectIdentifier(), () -> "Project identifier is required");
    isTrue(dto.getProjectIdentifier().length() >= 4
        && dto.getProjectIdentifier().length() <= 5,
      () -> "ProjectIdentifier please use 4 to 5 characters");
    hasText(dto.getDescription(), () -> "Project description is required");
  }

  @AfterMapping
  default void convert(@MappingTarget Project entity) {
    entity.setProjectIdentifier(entity.getProjectIdentifier().toUpperCase());
  }

}
