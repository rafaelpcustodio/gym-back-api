package com.dextra.spending.repository;

import com.dextra.spending.model.PhysicalExercise;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhysicalExerciseRepository extends MongoRepository<PhysicalExercise, Long> {

    List<PhysicalExercise> findAllById(Long id);

    List<PhysicalExercise> findByCustomerName(String name);
}
