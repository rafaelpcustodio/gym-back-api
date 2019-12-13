package com.dextra.gymapp.controller;

import com.dextra.gymapp.model.Exercise;
import com.dextra.gymapp.service.ExerciseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

@RestController
public class ExerciseController {

    private ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/users/{userId}/exercises/{exerciseId}")
    public List<Exercise> getExercisesByUserIdAndDate(
            @PathVariable(value = "userId") final Long userId,
            @PathVariable(value = "exerciseId") final Long exerciseId,
            @PathParam(value = "date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
        return this.exerciseService.findByUserIdAndExerciseIdAndDate(userId, exerciseId, date);
    }

    @DeleteMapping("/users/{userId}/exercises/{exerciseId}")
    public Exercise deleteExerciseByUserIdAndDate(
            @PathVariable(value = "userId") final Long userId,
            @PathVariable(value = "exerciseId") final Long exerciseId,
            @PathParam(value="date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
        return this.exerciseService.deleteByUserIdAndExerciseIdAndDate(userId, exerciseId, date);
    }

    @PostMapping("/users/{userId}/exercises")
    public Exercise saveExerciseByUserIdAndDate(@RequestBody Exercise exercise) {
        return this.exerciseService.saveExercise(exercise);
    }
}
