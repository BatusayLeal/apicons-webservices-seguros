package com.cristianleal.apicons.dto;

public class SaveLogRequestDTO {

    private Long idUser;
    private String externalApiName;
    private String endpoint;
    private String httpMethod;
    private String requestBody;
    private String responseBody;
    private Integer statusCode;
    private Long durationMs;

    /**
     * Constructor vacío requerido por Jackson/Spring para deserialización de JSON.
     */
    public SaveLogRequestDTO() {
        // Constructor vacío intencional
    }

    // Getters y Setters
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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
}