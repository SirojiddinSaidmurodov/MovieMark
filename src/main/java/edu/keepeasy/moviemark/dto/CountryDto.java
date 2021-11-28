package edu.keepeasy.moviemark.dto;

public class CountryDto extends EntityResource {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CountryDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
