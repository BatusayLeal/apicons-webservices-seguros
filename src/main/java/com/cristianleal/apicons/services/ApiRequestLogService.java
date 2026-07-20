package com.cristianleal.apicons.services;

import com.cristianleal.apicons.dto.ApiRequestLogDTO;
import com.cristianleal.apicons.models.ApiRequestLog;
import com.cristianleal.apicons.models.ApiUser;
import com.cristianleal.apicons.repositories.ApiRequestLogRepository;
import com.cristianleal.apicons.repositories.ApiUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApiRequestLogService {

    private final ApiRequestLogRepository logRepository;
    private final ApiUserRepository userRepository;

    @Transactional
    public ApiRequestLogDTO saveLog(Long idUser, String apiName, String endpoint,
                                    String method, String requestBody, String responseBody,
                                    Integer statusCode, Long durationMs) {

        ApiUser user = userRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        ApiRequestLog log = ApiRequestLog.builder()
                .user(user)
                .externalApiName(apiName)
                .endpoint(endpoint)
                .httpMethod(method)
                .requestBody(requestBody)
                .responseBody(responseBody)
                .statusCode(statusCode)
                .durationMs(durationMs)
                .timestamp(LocalDateTime.now())
                .build();

        ApiRequestLog saved = logRepository.save(log);

        return toDTO(saved);
    }

    public List<ApiRequestLogDTO> findAllOrdered() {
        return logRepository.findAllOrderByTimestampDesc()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<ApiRequestLogDTO> findByApiName(String apiName) {
        return logRepository.findByApiNameOrderByTimestampDesc(apiName)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
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