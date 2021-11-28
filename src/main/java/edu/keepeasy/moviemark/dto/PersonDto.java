package edu.keepeasy.moviemark.dto;

import java.time.LocalDate;

public class PersonDto extends EntityResource {
    private String fullName;
    private String originalName;
    private String sex;
    private LocalDate birthDate;
    private String birthPlace;

    public PersonDto() {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    @Override
    public String toString() {
        return "PersonDto{" +
                "fullName='" + fullName + '\'' +
                ", originalName='" + originalName + '\'' +
                ", sex='" + sex + '\'' +
                ", birthdate=" + birthDate +
                ", birthPlace='" + birthPlace + '\'' +
                '}';
    }
}
