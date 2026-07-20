package com.cristianleal.apicons.services;

import com.cristianleal.apicons.dto.ApiUserDTO;
import com.cristianleal.apicons.dto.RegisterRequestDTO;
import com.cristianleal.apicons.models.ApiUser;
import com.cristianleal.apicons.repositories.ApiUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApiUserService {

    private final ApiUserRepository apiUserRepository;
    private final PasswordEncoder passwordEncoder;

    public ApiUserService(ApiUserRepository apiUserRepository, PasswordEncoder passwordEncoder) {
        this.apiUserRepository = apiUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public ApiUserDTO registerLocalUser(RegisterRequestDTO request) {
        if (apiUserRepository.existsByNUser(request.getNUser())) {
            throw new ApiRequestException("El nombre de usuario ya existe");
        }
        if (apiUserRepository.existsByIdMail(request.getIdMail())) {
            throw new ApiRequestException("El correo ya está registrado");
        }

        ApiUser user = new ApiUser();
        user.setNUser(request.getNUser());
        user.setIdMail(request.getIdMail());
        user.setIdPass(passwordEncoder.encode(request.getIdPass()));
        user.setProvider("LOCAL");
        user.setActivo(true);

        ApiUser saved = apiUserRepository.save(user);

        ApiUserDTO dto = new ApiUserDTO();
        dto.setIdUser(saved.getIdUser());
        dto.setNUser(saved.getNUser());
        dto.setIdMail(saved.getIdMail());
        dto.setProvider(saved.getProvider());
        dto.setActivo(saved.getActivo());

        return dto;
    }

    public class ApiRequestException extends RuntimeException {

        public ApiRequestException(String message) {
            super(message);
        }

        public ApiRequestException(String message, Throwable cause) {
             super(message, cause);
        }
    }
}