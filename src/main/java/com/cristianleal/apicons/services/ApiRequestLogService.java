package com.cristianleal.apicons.services;

import com.cristianleal.apicons.dto.ApiRequestLogDTO;
import com.cristianleal.apicons.dto.SaveLogRequestDTO;
import com.cristianleal.apicons.models.ApiRequestLog;
import com.cristianleal.apicons.models.ApiUser;
import com.cristianleal.apicons.repositories.ApiRequestLogRepository;
import com.cristianleal.apicons.repositories.ApiUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiRequestLogService {

    private final ApiRequestLogRepository logRepository;
    private final ApiUserRepository userRepository;

    @Transactional
    public ApiRequestLogDTO saveLog(SaveLogRequestDTO request) {

        ApiUser user = userRepository.findById(request.getIdUser())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + request.getIdUser()));

        ApiRequestLog log = ApiRequestLog.builder()
                .user(user)
                .externalApiName(request.getExternalApiName())
                .endpoint(request.getEndpoint())
                .httpMethod(request.getHttpMethod())
                .requestBody(request.getRequestBody())
                .responseBody(request.getResponseBody())
                .statusCode(request.getStatusCode())
                .durationMs(request.getDurationMs())
                .timestamp(LocalDateTime.now())
                .build();

        ApiRequestLog saved = logRepository.save(log);
        return toDTO(saved);
    }

    public List<ApiRequestLogDTO> findAllOrdered() {
        return logRepository.findAllOrderByTimestampDesc()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public List<ApiRequestLogDTO> findByApiName(String apiName) {
        return logRepository.findByApiNameOrderByTimestampDesc(apiName)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    private ApiRequestLogDTO toDTO(ApiRequestLog log) {
        return ApiRequestLogDTO.builder()
                .id(log.getId())
                .idUser(log.getUser().getIdUser())
                .nUser(log.getUser().getNUser())
                .externalApiName(log.getExternalApiName())
                .endpoint(log.getEndpoint())
                .httpMethod(log.getHttpMethod())
                .requestBody(log.getRequestBody())
                .responseBody(log.getResponseBody())
                .statusCode(log.getStatusCode())
                .durationMs(log.getDurationMs())
                .timestamp(log.getTimestamp())
                .createdAt(log.getCreatedAt())
                .build();
    }
}