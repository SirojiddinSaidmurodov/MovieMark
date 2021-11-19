package edu.keepeasy.moviemark.controller;

import java.util.List;

public interface EntityController<Entity, IdType> {
    List<Entity> getAll();

    Entity getOne(IdType id);

    Entity edit(IdType id, Entity entity);

    Entity delete(IdType id);

    Entity create(Entity entity);
}
