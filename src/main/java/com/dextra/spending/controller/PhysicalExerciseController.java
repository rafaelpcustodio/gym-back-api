package com.dextra.spending.controller;

import com.dextra.spending.model.PhysicalExercise;
import com.dextra.spending.repository.PhysicalExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/physicalExercises")
public class PhysicalExerciseController {

    @Autowired
    private PhysicalExerciseRepository physicalExerciseRepository;

    @GetMapping
    public List<PhysicalExercise> findAll() {
        return this.physicalExerciseRepository.findAll();
    }

    @GetMapping("/exercises/{customerId}")
    public List<PhysicalExercise> getPhysicalExercisesByCustomerName(@PathVariable(value = "customerId", required = true) final Long customerId) {
        return this.physicalExerciseRepository.findAllById(customerId);
    }

    @DeleteMapping("/ids/{id}")
    public void deleteById(@PathVariable(value = "id", required = true) final Long id) {
        this.physicalExerciseRepository.deleteById(id);
    }

    @PostMapping
    public PhysicalExercise saveSpending(@RequestBody final PhysicalExercise spending) {
        return this.physicalExerciseRepository.save(spending);
    }
}
