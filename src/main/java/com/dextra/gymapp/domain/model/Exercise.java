package com.dextra.gymapp.domain.model;

import com.dextra.gymapp.domain.enums.ExerciseLevelTypes;
import com.dextra.gymapp.domain.enums.GroupExerciseTypes;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name="EXERCISES")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="exerciseId")
    private Long exerciseId;

    @Column(name="DATE")
    @NotNull
    private LocalDate date;

    @Column(name="CUSTOMER_NAME")
    @NotBlank
    private String customerName;

    @Column(name="EXERCISE_NAME")
    @NotBlank
    @Size(max = 40)
    private String name;

    @Column(name="URL_IMAGE")
    private String urlImage;

    @Column(name="WEIGHT")
    @NotNull
    private Long weight;

    @Column(name="SERIES")
    @NotBlank
    private String series;

    @Column(name="GROUP")
    @NotNull
    private GroupExerciseTypes group;

    @Column(name="LEVEL")
    @NotNull
    private ExerciseLevelTypes level;

    @ManyToOne
    private Train train;

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Exercise(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Exercise() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public GroupExerciseTypes getGroup() {
        return group;
    }

    public void setGroup(GroupExerciseTypes group) {
        this.group = group;
    }

    public ExerciseLevelTypes getLevel() {
        return level;
    }

    public void setLevel(ExerciseLevelTypes level) {
        this.level = level;
    }
}
