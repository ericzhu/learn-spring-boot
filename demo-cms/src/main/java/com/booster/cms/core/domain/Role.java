package com.booster.cms.core.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long              id;

    private String            name;

    public Role() {}

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private Set<UserRole> userRoles = new HashSet<>();

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

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
