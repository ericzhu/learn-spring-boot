package com.booster.cms.enums;

public enum PlanEnum {

    BASIC(1, "Basic"),
    PRO(2, "Pro");

    private PlanEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private final int    id;
    private final String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}