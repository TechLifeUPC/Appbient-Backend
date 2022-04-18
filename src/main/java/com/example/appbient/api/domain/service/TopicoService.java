package com.example.appbient.api.domain.service;

import com.example.appbient.api.domain.model.entity.Topico;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TopicoService {
    List<Topico> getAll();
    Topico getById(Long id);
    Topico create(Topico topico);
    Topico update(Long id, Topico topico);
    ResponseEntity<?> delete(Long Topicoid);
}
