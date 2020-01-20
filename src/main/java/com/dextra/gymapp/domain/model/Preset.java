package com.dextra.gymapp.domain.model;

import com.dextra.gymapp.domain.enums.ExerciseLevelTypes;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PRESET")
public class Preset implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="LEVEL")
    private ExerciseLevelTypes level;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.preset", cascade = CascadeType.ALL)
    private Set<PresetExercise> presetExercises = new HashSet<>();

    public Preset(){}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ExerciseLevelTypes getLevel() {
        return level;
    }

    public void setLevel(ExerciseLevelTypes level) {
        this.level = level;
    }
}
