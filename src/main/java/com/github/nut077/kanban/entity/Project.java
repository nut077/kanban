package com.github.nut077.kanban.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "projects")
public class Project extends Common {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Size(min = 4, max = 5)
  @Column(updatable = false, unique = true)
  private String projectIdentifier;

  private String projectName;
  private String description;
  private LocalDate startDate;
  private LocalDate endDate;
}
