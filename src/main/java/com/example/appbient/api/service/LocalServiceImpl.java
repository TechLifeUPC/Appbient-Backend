package com.example.appbient.api.service;

import com.example.appbient.api.domain.model.entity.Local;
import com.example.appbient.api.domain.persistence.LocalRepository;
import com.example.appbient.api.domain.persistence.OngRepository;
import com.example.appbient.api.domain.service.LocalService;
import com.example.appbient.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class LocalServiceImpl implements LocalService {
    private final String ENTITY="Local";

    private final LocalRepository localRepository;
    private final OngRepository ongRepository;
    private final Validator validator;

    public LocalServiceImpl(LocalRepository localRepository, OngRepository ongRepository, Validator validator) {
        this.localRepository = localRepository;
        this.ongRepository = ongRepository;
        this.validator = validator;
    }

    @Override
    public List<Local> getByOngId(Long ongId) {
        return localRepository.findAllByOngId(ongId);
    }

    @Override
    public Local create(Long ongId,Local request) {
        request.setOng(ongRepository.findById(ongId).orElseThrow(() -> new ResourceValidationException("Ong not found")));
        return localRepository.save(request);
    }

    @Override
    public Local update(Long id, Local request) {
        Set<ConstraintViolation<Local>> violations = validator.validate(request);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return localRepository.findById(id).map( l->
                localRepository.save(l.withAddress(request.getAddress())))
                .orElseThrow(() -> new ResourceValidationException("Local not found"));
    }

    @Override
    public ResponseEntity<?> delete(Long Localid) {
        return localRepository.findById(Localid)
                .map(local -> {
                    localRepository.delete(local);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceValidationException("Local not found"));
    }
}
