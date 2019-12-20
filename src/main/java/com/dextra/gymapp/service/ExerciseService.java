package com.dextra.gymapp.service;

import com.dextra.gymapp.dto.ExerciseDTO;
import com.dextra.gymapp.model.Exercise;
import com.dextra.gymapp.model.User;
import com.dextra.gymapp.repository.ExerciseRepository;
import com.dextra.gymapp.util.DateParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ExerciseService {

    private ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @Transactional(readOnly = true)
    public List<ExerciseDTO> findByUserAndExerciseIdAndDate(final User user, final String date){
        List<ExerciseDTO> exercisesDTO = new ArrayList<>();
        List<Exercise> exercises = this.exerciseRepository.findByUserAndDate(user, DateParser.convertStringToLocalDate(date));
        exercises.forEach(exercise -> {
            ExerciseDTO exerciseDTO = new ExerciseDTO();
            exerciseDTO.setId(exercise.getExerciseId());
            exerciseDTO.setLevel(exercise.getLevel());
            exerciseDTO.setName(exercise.getName());
            exerciseDTO.setSeries(exercise.getSeries());
            exerciseDTO.setGroup(exercise.getGroup());
            exerciseDTO.setWeight(exercise.getWeight());
            exerciseDTO.setUrlImage(exercise.getUrlImage());
            exercisesDTO.add(exerciseDTO);
        });
        return exercisesDTO;
    }

    public Exercise saveExercise(final Exercise exercise){
        return this.exerciseRepository.save(exercise);
    }

    public void deleteByUserIdAndExerciseIdAndDate(final Long userId, final Long exerciseId, final String date){
        this.exerciseRepository.deleteByUserUserIdAndExerciseIdAndDate(userId, exerciseId, DateParser.convertStringToLocalDate(date));
    }
}
