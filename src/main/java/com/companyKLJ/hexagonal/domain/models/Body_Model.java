package com.companyKLJ.hexagonal.domain.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Body_Model {

    private Long id;
    private Header_Model idHeader_Model;
    private String bodyNote;
    private String noReference;
    private LocalDate crationDate;
    private LocalTime crationTime;
    private LocalDateTime creationLocalDateTime;

    public Body_Model() {
    }

    public Body_Model(Long id, Header_Model idHeader_Model, String bodyNote, String noReference, LocalDate crationDate, LocalTime crationTime, LocalDateTime creationLocalDateTime) {
        this.id = id;
        this.idHeader_Model = idHeader_Model;
        this.bodyNote = bodyNote;
        this.noReference = noReference;
        this.crationDate = crationDate;
        this.crationTime = crationTime;
        this.creationLocalDateTime = creationLocalDateTime;
    }

    public static Body_Model init(Long id, Header_Model idHeader_Model, String bodyNote, String noReference, LocalDate crationDate, LocalTime crationTime, LocalDateTime creationLocalDateTime){
        return new Body_Model(id, idHeader_Model, bodyNote, noReference,crationDate, crationTime, creationLocalDateTime);
    }
    public static Body_Model init(){
        return new Body_Model();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Header_Model getIdHeader_Model() {
        return idHeader_Model;
    }

    public void setIdHeader_Model(Header_Model idHeader_Model) {
        this.idHeader_Model = idHeader_Model;
    }

    public String getBodyNote() {
        return bodyNote;
    }

    public void setBodyNote(String bodyNote) {
        this.bodyNote = bodyNote;
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
