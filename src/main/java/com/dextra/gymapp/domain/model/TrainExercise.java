package com.dextra.gymapp.domain.model;

import com.dextra.gymapp.domain.model.pk.TrainExerciseId;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Entity
@Table(name="TRAIN_EXERCISES")
@AssociationOverrides({
        @AssociationOverride(name="PK_TRAIN",
                joinColumns = @JoinColumn(name="TRAIN_ID")),
        @AssociationOverride(name="PK_EXERCISE",
        joinColumns = @JoinColumn(name="EXERCISE_ID")) })
public class TrainExercise  implements Serializable {

    @EmbeddedId
    @GeneratedValue
    @Column(name="TRAIN_EXERCISES_ID")
    private TrainExerciseId pk;

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

    public TrainExerciseId getPk() {
        return pk;
    }

    public void setPk(TrainExerciseId pk) {
        this.pk = pk;
    }

    public TrainExercise(){}

    public TrainExercise(TrainExerciseId pk) {
        this.pk = pk;
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
