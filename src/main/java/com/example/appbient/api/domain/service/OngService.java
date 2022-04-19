package com.example.appbient.api.domain.service;

import com.example.appbient.api.domain.model.entity.Ong;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OngService {
    List<Ong> getAll();
    Ong getById(Long id);
    Ong create(Ong request);
    Ong update(Long id, Ong request);
    ResponseEntity<?> delete(Long Ongid);
}
