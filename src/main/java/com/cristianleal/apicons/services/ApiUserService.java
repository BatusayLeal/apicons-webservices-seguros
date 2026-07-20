package com.cristianleal.apicons.services;

import com.cristianleal.apicons.dto.ApiUserDTO;
import com.cristianleal.apicons.dto.RegisterRequestDTO;
import com.cristianleal.apicons.models.ApiUser;
import com.cristianleal.apicons.repositories.ApiUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ApiUserService {

    private final ApiUserRepository apiUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public ApiUserDTO registerLocalUser(RegisterRequestDTO request) {
        if (apiUserRepository.existsByNUser(request.getNUser())) {
            throw new RuntimeException("El nombre de usuario ya existe");
        }
        if (apiUserRepository.existsByIdMail(request.getIdMail())) {
            throw new RuntimeException("El correo ya está registrado");
        }

        ApiUser user = ApiUser.builder()
                .nUser(request.getNUser())
                .idMail(request.getIdMail())
                .idPass(passwordEncoder.encode(request.getIdPass()))
                .provider("LOCAL")
                .activo(true)
                .build();

        ApiUser saved = apiUserRepository.save(user);

        return ApiUserDTO.builder()
                .idUser(saved.getIdUser())
                .nUser(saved.getNUser())
                .idMail(saved.getIdMail())
                .provider(saved.getProvider())
                .activo(saved.getActivo())
                .build();
    }
}