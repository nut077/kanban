package com.github.nut077.kanban.repository;

import com.github.nut077.kanban.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

  Optional<Project> findByProjectIdentifier(String projectIdentifier);
}
