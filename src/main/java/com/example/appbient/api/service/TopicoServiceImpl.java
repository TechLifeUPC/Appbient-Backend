package com.example.appbient.api.service;

import com.example.appbient.api.domain.model.entity.Topico;
import com.example.appbient.api.domain.persistence.TopicoRepository;
import com.example.appbient.api.domain.service.TopicoService;
import com.example.appbient.shared.exception.ResourceNotFoundException;
import com.example.appbient.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class TopicoServiceImpl implements TopicoService {

    private static final String ENTITY = "Topico";

    private final TopicoRepository topicoRepository;
    private final Validator validator;

    public TopicoServiceImpl(TopicoRepository topicoRepository, Validator validator) {
        this.topicoRepository = topicoRepository;
        this.validator = validator;
    }

    @Override
    public List<Topico> getAll() {
        return topicoRepository.findAll();
    }

    @Override
    public Topico getById(Long id) {
        return topicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public Topico create(Topico topico) {
        return topicoRepository.save(topico);
    }

    @Override
    public Topico update(Long id,Topico request) {
        Set<ConstraintViolation<Topico>> violations = validator.validate(request);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return topicoRepository.findById(id).map(
                t -> topicoRepository.save(
                            t.withName(request.getName())
                                    .withDescription(request.getDescription())
                    )
        ).orElseThrow( () -> new ResourceNotFoundException(ENTITY, request.getId()));
    }

    @Override
    public ResponseEntity<?> delete(Long Topicoid) {
        return topicoRepository.findById(Topicoid).map(t->{
            topicoRepository.delete(t);
            return ResponseEntity.ok().build();
        }).orElseThrow((() -> new ResourceNotFoundException(ENTITY, Topicoid)));
    }
}
