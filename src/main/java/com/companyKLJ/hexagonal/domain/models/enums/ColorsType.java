package com.companyKLJ.hexagonal.domain.models.enums;

public enum ColorsType {
    WHITE("BLANCO"),
    BLUE("AZUL"),
    BROWN("MARRON"),
    GREEN("VERDE"),
    ROUS("ROSADO"),
    YELLOW("AMARILLO"),
    RED("ROJO");

    private String color;

    ColorsType(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}
