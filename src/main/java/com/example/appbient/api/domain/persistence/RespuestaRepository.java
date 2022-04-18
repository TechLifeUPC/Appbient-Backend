package com.example.appbient.api.domain.persistence;

import com.example.appbient.api.domain.model.entity.RespuestaForo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespuestaRepository extends JpaRepository<RespuestaForo, Long> {

}
