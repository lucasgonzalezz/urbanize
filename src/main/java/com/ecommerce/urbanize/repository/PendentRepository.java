package com.ecommerce.urbanize.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.urbanize.entity.PendentEntity;

public interface PendentRepository extends JpaRepository<PendentEntity, Long> {

    // Find a pendent by its token
    Optional<PendentEntity> findByToken(String token);

}