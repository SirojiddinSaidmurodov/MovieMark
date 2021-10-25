package edu.keepeasy.moviemark.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(Set.of(
            new Permission(Actor.class, Action.READ),
            new Permission(Artist.class, Action.READ),
            new Permission(Country.class, Action.READ),
            new Permission(Movie.class, Action.READ),
            new Permission(Person.class, Action.READ),
            new Permission(Rate.class, Action.READ),
            new Permission(User.class, Action.READ)
    )),
    ADMIN(Set.of(
            new Permission(Actor.class, Action.READ),
            new Permission(Artist.class, Action.READ),
            new Permission(Country.class, Action.READ),
            new Permission(Movie.class, Action.READ),
            new Permission(Person.class, Action.READ),
            new Permission(Rate.class, Action.READ),
            new Permission(User.class, Action.READ),
            new Permission(Actor.class, Action.WRITE),
            new Permission(Artist.class, Action.WRITE),
            new Permission(Country.class, Action.WRITE),
            new Permission(Movie.class, Action.WRITE),
            new Permission(Person.class, Action.WRITE),
            new Permission(Rate.class, Action.WRITE),
            new Permission(User.class, Action.WRITE)
    ));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
