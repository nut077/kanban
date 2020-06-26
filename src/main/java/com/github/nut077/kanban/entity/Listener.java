package com.github.nut077.kanban.entity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.OffsetDateTime;

public class Listener<T extends Common> {

  @PrePersist
  private void prePersist(T e) {
    e.setCreateDate(OffsetDateTime.now());
  }

  @PreUpdate
  private void preUpdate(T e) {
    e.setUpdateDate(OffsetDateTime.now());
  }
}
