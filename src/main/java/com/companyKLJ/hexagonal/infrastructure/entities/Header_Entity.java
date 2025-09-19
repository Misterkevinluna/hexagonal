package com.companyKLJ.hexagonal.infrastructure.entities;

import com.companyKLJ.hexagonal.domain.models.enums.ContentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "header")
public class Header_Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generadorDeSecuenciasDe_id")
    @SequenceGenerator(name = "generadorDeSecuenciasDe_id", sequenceName = "secuenciasDeId", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "titleNote", nullable = true, length = 255)
    private String titleNote;
    @Column(name = "introNote", nullable = true, length = 255)
    private String introNote;
    @Column(name = "contentTypeEnum", nullable = true, length = 255)
    private String contentTypeEnum;
    @Column(name = "colorsTypeEnum", nullable = true, length = 255)
    private String colorsTypeEnum;
    @Column(name = "noReference", nullable = false, length = 255)
    private String noReference;//nunmero de referencia (unico)
    @Column(name = "crationDate",  columnDefinition = "DATE", nullable = false)
    private LocalDate crationDate;
    @Column(name = "crationTime",  columnDefinition = "TIME", nullable = false)
    private LocalTime crationTime;
    @Column(name = "creationLocalDateTime",  columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime creationLocalDateTime;

    public static Header_Entity init(){
        return new Header_Entity();
    }

}

   /*
    @PrePersist
    private void assignDateTime(){
        this.crationDate = (LocalDate) getEntityManager().createNativeQuery("SELECT CURDATE()",LocalDate.class).getSingleResult();
        this.crationTime = (LocalTime) getEntityManager().createNativeQuery("SELECT CURTIME()",LocalTime.class).getSingleResult();
        this.creationLocalDateTime = crationDate.atTime(crationTime);
    }*/
