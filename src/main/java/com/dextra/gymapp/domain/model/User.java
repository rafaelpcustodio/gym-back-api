package com.dextra.gymapp.domain.model;

import com.dextra.gymapp.domain.model.access.Permission;
import com.dextra.gymapp.domain.model.access.Role;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USER", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "USERNAME"
        }),
        @UniqueConstraint(columnNames = {
                "EMAIL"
        })
})
public class User extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USER_ID")
    private Long id;

    @NotBlank
    @Size(max = 40)
    @Column(name = "NAME")
    private String name;

    @NotBlank
    @Size(max = 15)
    @Column(name = "USERNAME")
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    @Column(name = "EMAIL")
    private String email;

    @NotBlank
    @Size(max = 100)
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "WEIGHT")
    private Long weight;

    @Column(name = "HEIGHT")
    private String height;

    @Column(name = "ADDRESS")
    private String address;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_ENTITY",
            joinColumns = @JoinColumn(name = "FK_USER", referencedColumnName = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "FK_ENTITY", referencedColumnName = "ENTITY_ID"))
    private Set<com.dextra.gymapp.domain.model.access.Entity> entities = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_PERMISSION",
            joinColumns = @JoinColumn(name = "FK_USER", referencedColumnName = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "FK_PERMISSION", referencedColumnName = "PERMISSION_ID"))
    private Set<Permission> permissions = new HashSet<>();

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "user")
    private List<Train> trains = new ArrayList<>();

    public Set<com.dextra.gymapp.domain.model.access.Entity> getEntities() {
        return entities;
    }

    public void setEntities(Set<com.dextra.gymapp.domain.model.access.Entity> entities) {
        this.entities = entities;
    }


    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public User(String name, String username, String email, String password, String address) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public User(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void addEntity(com.dextra.gymapp.domain.model.access.Entity e) {
        this.entities.add(e);
        e.getUsers().add(this);
    }

    public void removeEntity(com.dextra.gymapp.domain.model.access.Entity e) {
        this.entities.remove(e);
        e.getUsers().remove(this);
    }

    public void addPermission(Permission p) {
        this.permissions.add(p);
        p.getUsers().add(this);
    }

    public void removePermission(Permission p) {
        this.permissions.remove(p);
        p.getUsers().remove(this);
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}