package com.dextra.gymapp.domain.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="GROUP")
public class Group implements Serializable {

    @Id
    @GeneratedValue
    @JoinColumn(name="GROUP_ID")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    private Exercise exercise;

    @Column(name="NAME")
    private String name;

    @Column(name="DESCRIPTION")
    private String description;

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
