package com.example.appbient.api.domain.service;

import com.example.appbient.api.domain.model.entity.ComentariosForo;
import com.example.appbient.api.resource.ComentarioForo.CreateComentarioForoResource;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ComentarioForoService {
    List<ComentariosForo> findByForoId(Long foroId);
    ComentariosForo create(CreateComentarioForoResource comentario);
    ResponseEntity<?> delete(Long id);
}
