package com.github.nut077.kanban.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectDto {

  private String projectName;
  private String projectIdentifier;
  private String description;
  private String startDate;
  private String endDate;
}
