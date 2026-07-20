package com.cristianleal.apicons.dto;

import java.time.LocalDateTime;

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

    public ApiRequestLogDTO() {
        // Intentionally left blank.
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getExternalApiName() {
        return externalApiName;
    }

    public void setExternalApiName(String externalApiName) {
        this.externalApiName = externalApiName;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Long getDurationMs() {
        return durationMs;
    }

    public void setDurationMs(Long durationMs) {
        this.durationMs = durationMs;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}