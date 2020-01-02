package com.dextra.gymapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@javax.persistence.Entity
@Table(name="ENTITIES")
public class Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="entityId")
    private Long id;

    @NotBlank
    @Column(name = "NAME")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
