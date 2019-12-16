package com.dextra.gymapp.dto;

import com.dextra.gymapp.enums.GroupExerciseTypes;
import com.dextra.gymapp.enums.ExerciseLevelTypes;

public class ExerciseDTO {

    private String name;
    private Long weight;
    private String series;
    private String urlImage;
    private GroupExerciseTypes group;
    private ExerciseLevelTypes level;

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
