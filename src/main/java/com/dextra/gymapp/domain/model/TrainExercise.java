package com.dextra.gymapp.domain.model;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Entity
@Table(name="TRAIN_EXERCISES")
public class TrainExercise {

    @Id
    @GeneratedValue
    @Column(name="TRAIN_EXERCISES_ID")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @Column(name="TRAIN_ID")
    private Train train;

    @ManyToOne(cascade = CascadeType.ALL)
    @Column(name="EXERCISE_ID")
    private Exercise exercise;

    @Column(name="DAY_OF_WEEK")
    private DayOfWeek dayOfWeek;

    @Column(name="CREATION_DATE")
    private LocalDate creationDate;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="REPITITIONS")
    private Integer repititions;

    @Column(name="SERIES")
    private Integer series;

    @Column(name="FREQUENCY")
    private String frequency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRepititions() {
        return repititions;
    }

    public void setRepititions(Integer repititions) {
        this.repititions = repititions;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
