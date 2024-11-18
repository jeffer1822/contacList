package com.jeffer.contactlistapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String nombre;

    @NonNull
    private Integer telefono;

    @NonNull
    private String correo;

    @NonNull
    private String direccion;


    private LocalDateTime fechaRegistro;

}
