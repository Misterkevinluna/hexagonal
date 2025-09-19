package com.companyKLJ.hexagonal.domain.models.enums;

public enum ContentType {//tipo de contenido de la hoja, tarea, apunte, seguimiento, etc.

    TASK("TAREA"),
    NOTE("APUNTE"),
    OBSERVATION("OBSERVACION"),
    FOLLO_UP("SEGUIMIENTO");

    private String typeContent;


    ContentType(String typeContent) {
        this.typeContent = typeContent;
    }


    public String getTypeContent() {
        return typeContent;
    }

}
