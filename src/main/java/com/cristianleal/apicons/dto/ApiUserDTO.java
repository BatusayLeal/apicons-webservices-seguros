package com.cristianleal.apicons.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiUserDTO {

    private Long idUser;
    private String nUser;
    private String idMail;
    private String provider;
    private Boolean activo;
}