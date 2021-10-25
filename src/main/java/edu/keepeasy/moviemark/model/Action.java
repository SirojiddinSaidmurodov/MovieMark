package edu.keepeasy.moviemark.model;

public enum Action {
    READ("r"), WRITE("w");

    private final String action;

    Action(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }
}
