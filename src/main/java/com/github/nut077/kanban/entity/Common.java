package com.github.nut077.kanban.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.OffsetDateTime;

@Getter
@Setter
@EntityListeners(value = Listener.class)
@MappedSuperclass
public abstract class Common {

  private OffsetDateTime createDate;
  private OffsetDateTime updateDate;

  @Version
  private int version;
}
