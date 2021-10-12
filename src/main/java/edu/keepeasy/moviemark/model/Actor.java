package edu.keepeasy.moviemark.model;

import javax.persistence.*;

@Table(name = "actors")
@Entity
public class Actor {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;
    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean cameo;
    @ManyToOne
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public boolean isCameo() {
        return cameo;
    }

    public void setCameo(boolean cameo) {
        this.cameo = cameo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}