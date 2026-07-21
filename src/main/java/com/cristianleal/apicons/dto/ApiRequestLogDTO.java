package com.cristianleal.apicons.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiRequestLogDTO {

    private Long id;
    private Long idUser;
    private String nUser;
    private String externalApiName;
    private String endpoint;
    private String httpMethod;
    private String requestBody;
    private String responseBody;
    private Integer statusCode;
    private Long durationMs;
    private LocalDateTime timestamp;
    private LocalDateTime createdAt;
}