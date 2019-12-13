package com.dextra.gymapp.service;

import com.dextra.gymapp.model.Exercise;
import com.dextra.gymapp.repository.ExerciseRepository;
import com.dextra.gymapp.utils.DateParser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ExerciseService {

    private ExerciseRepository exerciseRepository;

    @Transactional(readOnly = true)
    public List<Exercise> findByUserIdAndExerciseIdAndDate(final Long userId, final Long exerciseId, final Date date){
        return null;
        // return this.exerciseRepository.findByUserIdAndExerciseIdAndDate(userId, exerciseId, DateParser.convertDateToLocalDate(date));
    }

    public Exercise saveExercise(final Exercise exercise){
        return this.exerciseRepository.save(exercise);
    }

    public Exercise deleteByUserIdAndExerciseIdAndDate(final Long userId, final Long exerciseId, final Date date){
        return null;
        // return this.exerciseRepository.deleteByUserIdAndExerciseIdAndDate(userId, exerciseId, DateParser.convertDateToLocalDate(date));
    }
}
