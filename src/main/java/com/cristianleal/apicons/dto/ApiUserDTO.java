package com.cristianleal.apicons.dto;

public class ApiUserDTO {

    private Long idUser;
    private String nUser;
    private String idMail;
    private String provider;
    private Boolean activo;

    public ApiUserDTO() {
        // Intentionally left blank.
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}