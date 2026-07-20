package com.cristianleal.apicons.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiUserDTO {

    private Long idUser;

    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Size(min = 3, max = 100)
    private String nUser;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El formato del correo no es válido")
    private String idMail;

    private String provider;
    private Boolean activo;
}