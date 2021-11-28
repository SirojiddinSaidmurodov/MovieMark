package edu.keepeasy.moviemark.dto;

public class ArtistDto extends EntityResource {
    private String role;
    private PersonDto person;

    public ArtistDto() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "ArtistDto{" +
                "role='" + role + '\'' +
                ", person=" + person +
                '}';
    }
}
