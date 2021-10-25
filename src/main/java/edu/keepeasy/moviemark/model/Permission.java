package edu.keepeasy.moviemark.model;

public class Permission {
    private final String permission;

    Permission(Class<?> entityClass, Action action) {
        String className = entityClass.getSimpleName();
        this.permission = className + ":" + action.getAction();
    }

    public String getPermission() {
        return permission;
    }

}
