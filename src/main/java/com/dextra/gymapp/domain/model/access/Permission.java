package com.dextra.gymapp.domain.model.access;


import com.dextra.gymapp.domain.model.User;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="PERMISSION")
public class Permission implements Serializable {

    @Id
    @Column(name="PERMISSION_ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    @ManyToMany(mappedBy = "permissions")
    private Set<User> users = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ROLE_PERMISSION",
            joinColumns = @JoinColumn(name = "FK_PERMISSION", referencedColumnName = "PERMISSION_ID"),
            inverseJoinColumns = @JoinColumn(name = "FK_ROLE", referencedColumnName = "ROLE_ID"))
    private Set<Role> roles = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addRole(Role r) {
        this.roles.add(r);
        r.getPermission().add(this);
    }

    public void removeRole(Role r) {
        this.roles.remove(r);
        r.getPermission().remove(this);
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
