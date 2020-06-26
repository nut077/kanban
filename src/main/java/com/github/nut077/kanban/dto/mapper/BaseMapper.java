package com.github.nut077.kanban.dto.mapper;

import org.mapstruct.InheritInverseConfiguration;

public interface BaseMapper<E, D> {

  D mapToDto(E entity);
  //List<D> mapToListDto(Collection<E> entity);
  @InheritInverseConfiguration
  E mapToEntity(D dto);
  //E mapToEntity(D dto, @MappingTarget E entity);
}
