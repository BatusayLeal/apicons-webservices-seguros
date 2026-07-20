package com.cristianleal.apicons.services;

import com.cristianleal.apicons.dto.ApiRequestLogDTO;
import com.cristianleal.apicons.dto.SaveLogRequestDTO;
import com.cristianleal.apicons.models.ApiRequestLog;
import com.cristianleal.apicons.models.ApiUser;
import com.cristianleal.apicons.repositories.ApiRequestLogRepository;
import com.cristianleal.apicons.repositories.ApiUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiRequestLogService {

    private final ApiRequestLogRepository logRepository;
    private final ApiUserRepository userRepository;

    public ApiRequestLogService(ApiRequestLogRepository logRepository, ApiUserRepository userRepository) {
        this.logRepository = logRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public ApiRequestLogDTO saveLog(SaveLogRequestDTO request) {

        ApiUser user = userRepository.findById(request.getIdUser())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + request.getIdUser()));

        ApiRequestLog log = new ApiRequestLog();
        log.setUser(user);
        log.setExternalApiName(request.getExternalApiName());
        log.setEndpoint(request.getEndpoint());
        log.setHttpMethod(request.getHttpMethod());
        log.setRequestBody(request.getRequestBody());
        log.setResponseBody(request.getResponseBody());
        log.setStatusCode(request.getStatusCode());
        log.setDurationMs(request.getDurationMs());
        log.setTimestamp(LocalDateTime.now());

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
        ApiRequestLogDTO dto = new ApiRequestLogDTO();
        dto.setId(log.getId());
        dto.setIdUser(log.getUser().getIdUser());
        dto.setNUser(log.getUser().getNUser());
        dto.setExternalApiName(log.getExternalApiName());
        dto.setEndpoint(log.getEndpoint());
        dto.setHttpMethod(log.getHttpMethod());
        dto.setRequestBody(log.getRequestBody());
        dto.setResponseBody(log.getResponseBody());
        dto.setStatusCode(log.getStatusCode());
        dto.setDurationMs(log.getDurationMs());
        dto.setTimestamp(log.getTimestamp());
        dto.setCreatedAt(log.getCreatedAt());
        return dto;
    }
}