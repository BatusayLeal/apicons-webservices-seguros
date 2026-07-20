package com.cristianleal.apicons.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveLogRequestDTO {

    private Long idUser;
    private String externalApiName;
    private String endpoint;
    private String httpMethod;
    private String requestBody;
    private String responseBody;
    private Integer statusCode;
    private Long durationMs;
}