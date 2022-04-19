package com.example.appbient.api.domain.service;

import com.example.appbient.api.domain.model.entity.ComentariosForo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ComentarioService {
    List<ComentariosForo> getAllasPublucacion(Long idPublicacion);
    ComentariosForo getById(Long id);
//    ComentariosForo create(CreateComentariosForoResource request);
    ComentariosForo update(Long id ,ComentariosForo ComentariosForo);
    ResponseEntity<?> delete(Long ComentariosForoId);
}
