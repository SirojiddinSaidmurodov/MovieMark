package edu.keepeasy.moviemark.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String fullName;
    private String originalName;
    @Enumerated(EnumType.ORDINAL)
    private Sex sex;
    private LocalDate birthDate;
    private String birthPlace;

    public Person(Long id, String fullName, String originalName, Sex sex, LocalDate birthDate, String birthPlace) {
        this.id = id;
        this.fullName = fullName;
        this.originalName = originalName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
    }

    public Person() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (getId() != null ? !getId().equals(person.getId()) : person.getId() != null) return false;
        if (getFullName() != null ? !getFullName().equals(person.getFullName()) : person.getFullName() != null)
            return false;
        if (getOriginalName() != null ? !getOriginalName().equals(person.getOriginalName()) : person.getOriginalName() != null)
            return false;
        if (getSex() != person.getSex()) return false;
        if (getBirthDate() != null ? !getBirthDate().equals(person.getBirthDate()) : person.getBirthDate() != null)
            return false;
        return getBirthPlace() != null ? getBirthPlace().equals(person.getBirthPlace()) : person.getBirthPlace() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getFullName() != null ? getFullName().hashCode() : 0);
        result = 31 * result + (getOriginalName() != null ? getOriginalName().hashCode() : 0);
        result = 31 * result + (getSex() != null ? getSex().hashCode() : 0);
        result = 31 * result + (getBirthDate() != null ? getBirthDate().hashCode() : 0);
        result = 31 * result + (getBirthPlace() != null ? getBirthPlace().hashCode() : 0);
        return result;
    }
}
