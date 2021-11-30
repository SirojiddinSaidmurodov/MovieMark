package edu.keepeasy.moviemark.service;

import edu.keepeasy.moviemark.dto.EntityResource;

public interface EntityService<EntityDTO extends EntityResource, Identifier extends Number> {

    EntityDTO save(EntityDTO dto);

    EntityDTO findById(Identifier id);

    EntityDTO updateById(EntityDTO dto);

    void delete(Identifier id);

    boolean isPresent(Identifier id);
}
