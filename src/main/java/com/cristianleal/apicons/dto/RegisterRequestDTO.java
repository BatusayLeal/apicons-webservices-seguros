package com.cristianleal.apicons.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequestDTO {

    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Size(min = 3, max = 100, message = "El usuario debe tener entre 3 y 100 caracteres")
    private String nUser;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El formato del correo no es válido")
    @Size(max = 150, message = "El correo no puede superar 150 caracteres")
    private String idMail;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, max = 100, message = "La contraseña debe tener al menos 6 caracteres")
    private String idPass;

    public RegisterRequestDTO() {
    }

    public String getNUser() {
        return nUser;
    }

    public void setNUser(String nUser) {
        this.nUser = nUser;
    }

    public String getIdMail() {
        return idMail;
    }

    public void setIdMail(String idMail) {
        this.idMail = idMail;
    }

    public String getIdPass() {
        return idPass;
    }

    public void setIdPass(String idPass) {
        this.idPass = idPass;
    }
}