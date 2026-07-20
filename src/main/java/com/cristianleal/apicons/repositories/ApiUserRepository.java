package com.cristianleal.apicons.repositories;

import com.cristianleal.apicons.models.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApiUserRepository extends JpaRepository<ApiUser, Long> {

    Optional<ApiUser> findByNUser(String nUser);
    Optional<ApiUser> findByIdMail(String idMail);
    Optional<ApiUser> findByProviderAndProviderId(String provider, String providerId);
    boolean existsByNUser(String nUser);
    boolean existsByIdMail(String idMail);
}