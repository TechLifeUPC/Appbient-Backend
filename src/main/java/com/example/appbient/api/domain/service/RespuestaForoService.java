package com.example.appbient.api.domain.service;

import com.example.appbient.api.domain.model.entity.RespuestaForo;
import com.example.appbient.api.resource.RespuestaForo.CreateRespuestaForoResource;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RespuestaForoService {
    List<RespuestaForo> findByComentario(Long ComentarioId);
    RespuestaForo create(CreateRespuestaForoResource respuestaForo);
    ResponseEntity<?> delete(Long id);
}
