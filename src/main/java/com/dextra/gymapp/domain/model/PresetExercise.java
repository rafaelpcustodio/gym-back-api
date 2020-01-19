package com.dextra.gymapp.domain.model;

import com.dextra.gymapp.domain.model.pk.PresetExerciseId;
import com.dextra.gymapp.domain.model.pk.TrainExerciseId;

import javax.persistence.*;

@Entity
@Table(name="PRESET_EXERCISE")
@AssociationOverrides({
        @AssociationOverride(name="PK_PRESET",
                joinColumns = @JoinColumn(name="PRESET_ID")),
        @AssociationOverride(name="PK_EXERCISE",
                joinColumns = @JoinColumn(name="EXERCISE_ID")) })
public class PresetExercise {

    @EmbeddedId
    @GeneratedValue
    @Column(name="PRESET_EXERCISE_ID")
    private PresetExerciseId id;

    @Column(name="REPETITIONS")
    private Integer repetitions;

    @Column(name="SERIES")
    private Integer series;

    @Column(name="DAY_OF_WEEK")
    private String dayOfWeek;

    public PresetExerciseId getId() {
        return id;
    }

    public void setId(PresetExerciseId id) {
        this.id = id;
    }

    public Integer getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Integer repetitions) {
        this.repetitions = repetitions;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
