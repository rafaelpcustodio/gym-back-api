package com.dextra.spending.model;

import com.dextra.spending.enums.GroupPhysicalExerciseTypes;
import com.dextra.spending.enums.PhysicalExerciseLevelTypes;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="PHYSICAL_EXERCISES")
public class PhysicalExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Long userId;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public PhysicalExercise(Long id) {
        this.id = id;
    }

    public PhysicalExercise() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
