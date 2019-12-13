package com.dextra.gymapp.dto;

import com.dextra.gymapp.enums.GroupPhysicalExerciseTypes;
import com.dextra.gymapp.enums.PhysicalExerciseLevelTypes;

public class PhysicalExerciseDTO {

    private String customerName;
    private String name;
    private Long weight;
    private String series;
    private GroupPhysicalExerciseTypes groupPhysicalExerciseTypes;
    private PhysicalExerciseLevelTypes level;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public GroupPhysicalExerciseTypes getGroupPhysicalExerciseTypes() {
        return groupPhysicalExerciseTypes;
    }

    public void setGroupPhysicalExerciseTypes(GroupPhysicalExerciseTypes groupPhysicalExerciseTypes) {
        this.groupPhysicalExerciseTypes = groupPhysicalExerciseTypes;
    }

    public PhysicalExerciseLevelTypes getLevel() {
        return level;
    }

    public void setLevel(PhysicalExerciseLevelTypes level) {
        this.level = level;
    }
}
