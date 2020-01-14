package com.dextra.gymapp.domain.repository;

import com.dextra.gymapp.domain.model.Exercise;
import com.dextra.gymapp.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    List<Exercise> findByUserAndDate(User user, LocalDate date);

    void deleteByUserUserIdAndExerciseIdAndDate(Long userId, Long exerciseId, LocalDate date);

}
