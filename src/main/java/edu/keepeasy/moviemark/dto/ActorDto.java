package edu.keepeasy.moviemark.dto;

public class ActorDto extends EntityResource {
    private String role;
    private boolean cameo;
    private PersonDto person;

    public ActorDto() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isCameo() {
        return cameo;
    }

    public void setCameo(boolean cameo) {
        this.cameo = cameo;
    }

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "ActorDto{" +
                "role='" + role + '\'' +
                ", cameo=" + cameo +
                ", person=" + person +
                '}';
    }
}
