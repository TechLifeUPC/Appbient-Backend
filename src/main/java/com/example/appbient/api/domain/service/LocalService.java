package com.example.appbient.api.domain.service;

import com.example.appbient.api.domain.model.entity.Local;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LocalService {
    List<Local> getByOngId(Long ongId);
    Local create(Long ongId,Local request);
    Local update(Long id, Local request);
    ResponseEntity<?> delete(Long Localid);
}
