package com.example.appbient.api.domain.persistence;

import com.example.appbient.api.domain.model.entity.RespuestaForo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespuestaForoRepository extends JpaRepository<RespuestaForo, Long> {
    List<RespuestaForo> findByComentarioId(Long comentarioId);
}
