package com.dextra.gymapp.dto;

import com.dextra.gymapp.enums.GroupPhysicalExerciseTypes;
import com.dextra.gymapp.enums.PhysicalExerciseLevelTypes;

public class ExerciseDTO {

    private String name;
    private Long weight;
    private String series;
    private String urlImage;
    private GroupPhysicalExerciseTypes group;
    private PhysicalExerciseLevelTypes level;

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
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
