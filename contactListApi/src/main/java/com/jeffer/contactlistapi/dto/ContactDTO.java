package com.jeffer.contactlistapi.dto;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ContactDTO {
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotNull(message = "El telefono es obligatorio")
    private Integer telefono;
    @Email(message = "El correo es invalido")
    @NotBlank(message = "El correo es obligatorio")
    private String correo;
    @NotBlank(message = "El direccion es obligatorio")
    private String direccion;

}
