package com.dextra.gymapp.domain.model.pk;

import com.dextra.gymapp.domain.model.Exercise;
import com.dextra.gymapp.domain.model.Preset;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class PresetExerciseId implements Serializable {

    @ManyToOne
    private Preset preset;

    @ManyToOne
    private Exercise exercise;

    public PresetExerciseId() {
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Preset getPreset() {
        return preset;
    }

    public void setPreset(Preset preset) {
        this.preset = preset;
    }
}
