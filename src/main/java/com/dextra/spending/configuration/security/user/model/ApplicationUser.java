package com.dextra.spending.configuration.security.user.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="USER")
public class ApplicationUser implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", length = 150)
    @NotNull
    private String name;

    @Column(name = "URL")
    private String urlImage;

    @Column(name = "EMAIL")
    @NotNull
    private String email;

    @Column(name = "PROFESSION")
    @NotNull
    private String profession;

    @Column(name = "ADDRESS")
    @NotNull
    private String address;

    @Column(name = "SALARY")
    @NotNull
    private BigDecimal salary;

    @Column(name = "USERNAME", unique = true, length = 50)
    @NotNull
    private String username;

    @Column(name = "PASSWORD", length = 100)
    @NotNull
    private String password;

    @Column(name="ENABLED")
    @NotNull
    private Boolean enabled;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
