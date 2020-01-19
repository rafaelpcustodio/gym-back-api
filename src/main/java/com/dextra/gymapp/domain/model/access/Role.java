package com.dextra.gymapp.domain.model.access;


import com.dextra.gymapp.domain.enums.RoleName;
import com.dextra.gymapp.domain.model.User;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ROLES")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ROLE_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(name="NAME", length = 60)
    private RoleName name;

    @ManyToMany(mappedBy = "PERMISSION")
    private Set<Permission> permission = new HashSet<>();

    public Set<Permission> getPermission() {
        return permission;
    }

    public void setPermission(Set<Permission> permission) {
        this.permission = permission;
    }

    public Role() {

    }

    public Role(RoleName name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}
