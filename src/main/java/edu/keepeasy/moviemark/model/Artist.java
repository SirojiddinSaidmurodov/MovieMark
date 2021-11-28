package edu.keepeasy.moviemark.model;

import javax.persistence.*;

@Entity
public class Artist {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;
    @ManyToOne
    private Person person;

    public Artist(Long id, String role, Person person) {
        this.id = id;
        this.role = role;
        this.person = person;
    }

    public Artist() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
