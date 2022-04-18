package com.example.appbient.api.domain.service;

import com.example.appbient.api.domain.model.entity.PublicacionForo;
import com.example.appbient.api.resource.PublicacionForo.CreatePublicacionForoResource;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PublicacionForoService {
    List<PublicacionForo> getAll();
    PublicacionForo getById(Long id);
    PublicacionForo create(CreatePublicacionForoResource request);
    PublicacionForo update(Long id ,PublicacionForo publicacionForo);
    ResponseEntity<?> delete(Long PublicacionForoId);
}
