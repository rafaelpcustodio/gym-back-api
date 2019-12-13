package com.dextra.gymapp.model;

import com.dextra.gymapp.enums.GroupPhysicalExerciseTypes;
import com.dextra.gymapp.enums.PhysicalExerciseLevelTypes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NotBlank
    private LocalDate date;

    @Column(name="CUSTOMER_NAME")
    @NotBlank
    private String customerName;

    @Column(name="EXERCISE_NAME")
    @NotBlank
    @Size(max = 40)
    private String name;

    @Column(name="WEIGHT")
    @NotBlank
    private Long weight;

    @Column(name="SERIES")
    @NotBlank
    private String series;

    @Column(name="GROUP")
    @NotBlank
    private GroupPhysicalExerciseTypes group;

    @Column(name="LEVEL")
    @NotBlank
    private PhysicalExerciseLevelTypes level;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "userId", foreignKey = @ForeignKey(name="FK_EXERCISE_USER"))
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public GroupPhysicalExerciseTypes getGroup() {
        return group;
    }

    public void setGroup(GroupPhysicalExerciseTypes group) {
        this.group = group;
    }

    public PhysicalExerciseLevelTypes getLevel() {
        return level;
    }

    public void setLevel(PhysicalExerciseLevelTypes level) {
        this.level = level;
    }
}
