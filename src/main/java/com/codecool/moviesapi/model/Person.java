package com.codecool.moviesapi.model;

import com.codecool.moviesapi.helper.DateDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "people")
public class Person implements Indexable, Archivable, Validable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @Column(columnDefinition = "boolean default true")
    private boolean isActive = true;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String surname;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String bio;

    @JsonFormat(pattern="yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date dateOfBirth;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @ManyToOne
    private Country country;

    public Person(String name, String surname, String bio, Date dateOfBirth, Country country) {
        this.name = name;
        this.surname = surname;
        this.bio = bio;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", bio='" + bio + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", country=" + country +
                '}';
    }

    @Override
    public boolean getIsActive() {
        return isActive;
    }

    @Override
    public void setIsActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean isValid() {
        return !((name == null) || (surname == null) || isDateInTheFuture(dateOfBirth));
    }

    private boolean isDateInTheFuture(Date date) {
        Date now = new Date(new java.util.Date().getTime());
        return date.after(now);
    }
}
