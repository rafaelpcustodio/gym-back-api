package com.dextra.gymapp.repository;

import com.dextra.gymapp.model.Exercise;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends MongoRepository<Exercise, Long> {

}
