package com.companyKLJ.hexagonal.domain.models;

import com.companyKLJ.hexagonal.domain.models.enums.ColorsType;
import com.companyKLJ.hexagonal.domain.models.enums.ContentType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Header_Model {
    private Long id;
    private String titleNote;
    private String introNote;
    private ContentType contentTypeEnum;
    private ColorsType colorsTypeEnum;
    private String noReference;//nunmero de referencia (unico)
    private LocalDate crationDate;
    private LocalTime crationTime;
    private LocalDateTime creationLocalDateTime;


    public Header_Model() {
    }

    private Header_Model(Long id, String titleNote, String introNote, ContentType contentTypeEnum, ColorsType colorsTypeEnum, String noReference, LocalDate crationDate, LocalTime crationTime, LocalDateTime creationLocalDateTime) {
        this.id = id;
        this.titleNote = titleNote;
        this.introNote = introNote;
        this.contentTypeEnum = contentTypeEnum;
        this.colorsTypeEnum = colorsTypeEnum;
        this.noReference = noReference;
        this.crationDate = crationDate;
        this.crationTime = crationTime;
        this.creationLocalDateTime = creationLocalDateTime;
    }

    public static Header_Model init(Long id, String titleNote, String introNote, ContentType contentTypeEnum, ColorsType colorsTypeEnum, String noReference, LocalDate crationDate, LocalTime crationTime, LocalDateTime creationLocalDateTime){
        return new Header_Model(id, titleNote, introNote, contentTypeEnum, colorsTypeEnum, noReference, crationDate, crationTime, creationLocalDateTime);
    }
    public static Header_Model init(){
        return new Header_Model();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitleNote() {
        return titleNote;
    }

    public void setTitleNote(String titleNote) {
        this.titleNote = titleNote;
    }

    public String getIntroNote() {
        return introNote;
    }

    public void setIntroNote(String introNote) {
        this.introNote = introNote;
    }

    public ContentType getContentTypeEnum() {
        return contentTypeEnum;
    }

    public void setContentTypeEnum(ContentType contentTypeEnum) {
        if (contentTypeEnum == null) {
            this.contentTypeEnum = ContentType.NOTE; // Valor por defecto
        } else {
            this.contentTypeEnum = contentTypeEnum;
        }
    }

    public ContentType setContentTypeEnumByString(String tag) {//tag = etiqueta
        this.contentTypeEnum = ContentType.NOTE;
        for (ContentType type : ContentType.values()){
            if (type.getTypeContent().equalsIgnoreCase(tag)){
                System.out.println("-------------------------------------------- SI ENTRO");
                this.contentTypeEnum = type;
                //System.out.println("-------------------------------------------- VALOR:  "+ contentTypeEnum.name());
                return contentTypeEnum;
            } else if (tag == null) {
                System.out.println("-------------------------------------------- NO ENTRO");
                this.contentTypeEnum = ContentType.NOTE;//por defecto será de tipo NOTE=APUNTE
                return this.contentTypeEnum;
            } else if (type.name().equals(tag)) {
                System.out.println("-------------------------------------------- SEGUNDA ENTRADA CONTENT");
                this.contentTypeEnum = type;
                return contentTypeEnum;
            }
            /*else {
                this.contentTypeEnum = ContentType.NOTE;//por defecto será de tipo NOTE=APUNTE
                return this.contentTypeEnum;
            }*/
        }
        return contentTypeEnum;
    }

    public ColorsType getColorsTypeEnum() {
        return colorsTypeEnum;
    }

    public void setColorsTypeEnum(ColorsType colorsTypeEnum) {
        if (colorsTypeEnum == null) {
            this.colorsTypeEnum = colorsTypeEnum.WHITE; // Valor por defecto
        } else {
            this.colorsTypeEnum = colorsTypeEnum;
        }
    }

    public ColorsType setColorsTypeEnumByString(String nbrColor) {//nbr = nombre del color
        this.colorsTypeEnum = ColorsType.WHITE;
        for (ColorsType type : ColorsType.values()){
            if (type.getColor().equalsIgnoreCase(nbrColor)){
                System.out.println("-------------------------------------------- SI ENTRO");
                this.colorsTypeEnum = type;
                //System.out.println("-------------------------------------------- VALOR:  "+ contentTypeEnum.name());
                return colorsTypeEnum;
            } else if (nbrColor == null) {
                System.out.println("-------------------------------------------- NO ENTRO");
                this.colorsTypeEnum = ColorsType.WHITE;//por defecto será de color blanco
                return this.colorsTypeEnum;
            } else if (type.name().equals(nbrColor)) {
                System.out.println("-------------------------------------------- SEGUNDA ENTRADA COLOR");
                this.colorsTypeEnum = type;
                return colorsTypeEnum;
            }
            /* else {
                System.out.println("-------------------------------------------- NO ENTRO 22");
                this.colorsTypeEnum = ColorsType.WHITE;//por defecto será de color blanco
                return this.colorsTypeEnum;
            }*/
        }
        return colorsTypeEnum;
    }

    public String getNoReference() {
        return noReference;
    }

    public void setNoReference(String noReference) {
        this.noReference = noReference;
    }

    public LocalDate getCrationDate() {
        return crationDate;
    }

    public void setCrationDate(LocalDate crationDate) {
        this.crationDate = crationDate;
    }

    public LocalTime getCrationTime() {
        return crationTime;
    }

    public void setCrationTime(LocalTime crationTime) {
        this.crationTime = crationTime;
    }

    public LocalDateTime getCreationLocalDateTime() {
        return creationLocalDateTime;
    }

    public void setCreationLocalDateTime(LocalDateTime creationLocalDateTime) {
        this.creationLocalDateTime = creationLocalDateTime;
    }
}
