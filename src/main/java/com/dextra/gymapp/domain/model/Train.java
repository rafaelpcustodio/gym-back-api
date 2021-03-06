package com.dextra.gymapp.domain.model;


import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TRAIN")
public class Train implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="INITIAL_DATE")
    private LocalDate initialDate;

    @Column(name="END_DATE")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user", nullable = false)
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.train", cascade = CascadeType.ALL)
    private Set<TrainExercise> trainExercises = new HashSet<>();

    public Train(){}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<TrainExercise> getTrainExercises() {
        return trainExercises;
    }

    public void setTrainExercises(Set<TrainExercise> trainExercises) {
        this.trainExercises = trainExercises;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
