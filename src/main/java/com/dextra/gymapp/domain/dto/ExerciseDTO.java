package com.dextra.gymapp.domain.dto;

import com.dextra.gymapp.domain.enums.ExerciseLevelTypes;
import com.dextra.gymapp.domain.enums.GroupExerciseTypes;

public class ExerciseDTO {

    private Long id;
    private String name;
    private Long weight;
    private String series;
    private String urlImage;
    private String group;
    private ExerciseLevelTypes level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public ExerciseLevelTypes getLevel() {
        return level;
    }

    public void setLevel(ExerciseLevelTypes level) {
        this.level = level;
    }
}
