package com.booster.ecom.entity;

public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;
    
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
