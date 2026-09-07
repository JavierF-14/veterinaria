package com.example.veterinaria.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "historias_clinicas")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private LocalDate fechaApertura;
    private String antecedentes;
    private String observaciones;

    @OneToOne
    @JoinColumn(name = "mascota_id", unique = true)
    private Mascota mascota;
}
