package com.booster.cms.enums;

public enum RoleEnum {

    BASIC(1, "ROLE_BASIC"),
    PRO(2, "ROLE_PRO"),
    ADMIN(3, "ROLE_ADMIN");

    private final int    id;
    private final String name;

    private RoleEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}