package edu.keepeasy.moviemark.model;

public enum Permission {
    MOVIE_R("movie:r"),
    MOVIE_W("movie:w");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

}
