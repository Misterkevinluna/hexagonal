package com.companyKLJ.hexagonal.infrastructure.entities;

import com.companyKLJ.hexagonal.domain.models.Header_Model;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@SuperBuilder
@Table(name = "body")
public class Body_Entity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generadorDeSecuenciasDe_id")
    @SequenceGenerator(name = "generadorDeSecuenciasDe_id", sequenceName = "secuenciasDeId", allocationSize = 1)
    private Long id;
    @NotNull
    @NonNull
    @Column(name = "idHeader_Model", nullable = false)
    private Long idHeader_Model;
    @Column(name = "bodyNote", nullable = true, length = 255)
    private String bodyNote;
    @NotNull
    @NonNull
    @Column(name = "noReference", nullable = false, length = 400)
    private String noReference;
    @Column(name = "crationDate", nullable = false, columnDefinition = "DATE")
    private LocalDate crationDate;
    @Column(name = "crationTime", nullable = false, columnDefinition = "TIME")
    private LocalTime crationTime;
    @Column(name = "creationLocalDateTime", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime creationLocalDateTime;

    public static Body_Entity init() {
        return new Body_Entity();
    }
}
