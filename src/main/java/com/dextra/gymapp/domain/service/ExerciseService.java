package com.dextra.gymapp.domain.service;

import com.dextra.gymapp.domain.dto.ExerciseDTO;
import com.dextra.gymapp.domain.model.Exercise;
import com.dextra.gymapp.domain.model.User;
import com.dextra.gymapp.domain.repository.ExerciseRepository;
import com.dextra.gymapp.domain.util.DateParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public List<ExerciseDTO> findByUserAndIdAndDate(final User user, final String date){
        List<ExerciseDTO> exercisesDTO = new ArrayList<>();
//        List<Exercise> exercises = this.exerciseRepository.findByUserAndDate(user, DateParser.convertStringToLocalDate(date));
//        exercises.forEach(exercise -> {
//            ExerciseDTO exerciseDTO = new ExerciseDTO();
//            exerciseDTO.setId(exercise.getId());
//            exerciseDTO.setLevel(exercise.getLevel());
//            exerciseDTO.setName(exercise.getName());
//            exerciseDTO.setSeries(exercise.getSeries());
//            exerciseDTO.setGroup(exercise.getGroup().getName());
//            exerciseDTO.setWeight(exercise.getWeight());
//            exerciseDTO.setUrlImage(exercise.getImage().getUrl());
//            exercisesDTO.add(exerciseDTO);
//        });
        return exercisesDTO;
    }

    public Exercise saveExercise(final Exercise exercise){
        return this.exerciseRepository.save(exercise);
    }

    public void deleteByUserIdAndIdAndDate(final Long userId, final Long exerciseId, final String date){
        // this.exerciseRepository.deleteByUserUserIdAndExerciseIdAndDate(userId, exerciseId, DateParser.convertStringToLocalDate(date));
    }
}
