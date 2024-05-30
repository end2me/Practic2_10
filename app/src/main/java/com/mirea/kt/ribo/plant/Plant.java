package com.mirea.kt.ribo.plant;

public class Plant {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isGreenhouse() {
        return isGreenhouse;
    }

    public void setGreenhouse(boolean greenhouse) {
        isGreenhouse = greenhouse;
    }

    private String name;
    private String type;
    private boolean isGreenhouse;

    public Plant(String name, String type, boolean isGreenhouse) {
        this.name = name;
        this.type = type;
        this.isGreenhouse = isGreenhouse;
    }
}
