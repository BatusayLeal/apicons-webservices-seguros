package com.cristianleal.apicons.repositories;

import com.cristianleal.apicons.models.ApiRequestLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ApiRequestLogRepository extends JpaRepository<ApiRequestLog, Long> {

    List<ApiRequestLog> findByUserIdUserOrderByTimestampDesc(Long idUser);

    @Query("SELECT l FROM ApiRequestLog l WHERE l.externalApiName = :apiName ORDER BY l.timestamp DESC")
    List<ApiRequestLog> findByApiNameOrderByTimestampDesc(@Param("apiName") String apiName);

    @Query("SELECT l FROM ApiRequestLog l ORDER BY l.timestamp DESC")
    List<ApiRequestLog> findAllOrderByTimestampDesc();

    Optional<ApiRequestLog> findFirstByUserIdUserOrderByTimestampDesc(Long idUser);
}