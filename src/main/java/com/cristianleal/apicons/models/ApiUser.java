package com.cristianleal.apicons.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "api_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "n_user", nullable = false, unique = true, length = 100)
    private String nUser;

    @Column(name = "id_mail", nullable = false, unique = true, length = 150)
    private String idMail;

    @Column(name = "id_pass", length = 255)
    private String idPass;

    @Column(name = "provider", nullable = false, length = 20)
    private String provider = "LOCAL";   // LOCAL, GOOGLE, LDAP

    @Column(name = "provider_id", length = 255)
    private String providerId;

    @Column(name = "activo", nullable = false)
    private Boolean activo = true;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}