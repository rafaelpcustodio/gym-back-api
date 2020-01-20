package com.dextra.gymapp.domain.model.pk;

import com.dextra.gymapp.domain.model.Exercise;
import com.dextra.gymapp.domain.model.Train;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class TrainExerciseId implements Serializable {

    @ManyToOne
    private Exercise exercise;

    @ManyToOne
    private Train train;

    public Exercise getExercise() {
        return exercise;
    }

    public TrainExerciseId() {
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
