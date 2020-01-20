package com.dextra.gymapp.domain.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="EXERCISE_IMAGE")
public class ExerciseImage implements Serializable {

    @Id
    @GeneratedValue
    @JoinColumn(name="IMAGE_ID")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    private Exercise exercise;

    public ExerciseImage() {
    }

    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
