package com.dextra.gymapp.domain.model;

import com.dextra.gymapp.domain.enums.ExerciseLevelTypes;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="EXERCISE")
public class Exercise implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="IMAGE_ID")
    private ExerciseImage image;

    @Column(name="WEIGHT")
    @NotNull
    private Long weight;

    @Column(name="SERIES")
    @NotBlank
    private String series;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="GROUP_ID")
    private Group group;

    @Column(name="LEVEL")
    @NotNull
    private ExerciseLevelTypes level;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.exercise")
    private Set<TrainExercise> trainExercises = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.exercise")
    private Set<PresetExercise> presetExercises = new HashSet<>();



    public Set<PresetExercise> getPresetExercises() {
        return presetExercises;
    }

    public void setPresetExercises(Set<PresetExercise> presetExercises) {
        this.presetExercises = presetExercises;
    }

    public Set<TrainExercise> getTrainExercises() {
        return trainExercises;
    }

    public void setTrainExercises(Set<TrainExercise> trainExercises) {
        this.trainExercises = trainExercises;
    }

    public ExerciseImage getImage() {
        return image;
    }

    public void setImage(ExerciseImage image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Exercise() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public ExerciseLevelTypes getLevel() {
        return level;
    }

    public void setLevel(ExerciseLevelTypes level) {
        this.level = level;
    }
}
