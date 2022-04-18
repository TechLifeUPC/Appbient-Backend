package com.example.appbient.api.service;

import com.example.appbient.api.domain.model.entity.PublicacionForo;
import com.example.appbient.api.domain.model.entity.Topico;
import com.example.appbient.api.domain.model.entity.Voluntario;
import com.example.appbient.api.domain.persistence.PublicacionForoRepository;
import com.example.appbient.api.domain.persistence.TopicoRepository;
import com.example.appbient.api.domain.persistence.VoluntarioRepository;
import com.example.appbient.api.domain.service.PublicacionForoService;
import com.example.appbient.api.resource.PublicacionForo.CreatePublicacionForoResource;
import com.example.appbient.shared.exception.ResourceNotFoundException;
import com.example.appbient.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class PublicacionForoServiceImpl implements PublicacionForoService {
    
    private static final String ENTITY = "PublicacionForo";
    private final PublicacionForoRepository pubForoRepository;
    private final TopicoRepository topicoRepository;
    private final VoluntarioRepository voluntarioRepository;
    private final Validator validator;

    public PublicacionForoServiceImpl(PublicacionForoRepository pubForoRepository, TopicoRepository topicoRepository, VoluntarioRepository voluntarioRepository, Validator validator) {
        this.pubForoRepository = pubForoRepository;
        this.topicoRepository = topicoRepository;
        this.voluntarioRepository = voluntarioRepository;
        this.validator = validator;
    }

    @Override
    public List<PublicacionForo> getAll() {
        return pubForoRepository.findAll();
    }

    @Override
    public PublicacionForo getById(Long id) {
        return pubForoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public PublicacionForo create(CreatePublicacionForoResource request) {
        Topico _topico = topicoRepository.findById(request.getTopicoId()).orElseThrow(() -> new ResourceNotFoundException(ENTITY, request.getTopicoId()) );
        Voluntario _voluntario = voluntarioRepository.findById(request.getVoluntarioId()).orElseThrow(() -> new ResourceNotFoundException(ENTITY, request.getVoluntarioId()) );
        PublicacionForo publicacion = new PublicacionForo();
            publicacion.setTopico(_topico);
            publicacion.setVoluntario(_voluntario);
            publicacion.setName(request.getName());
            publicacion.setDescription(request.getDescription());
            publicacion.setActive(request.isActive());
        return pubForoRepository.save(publicacion);
    }

    @Override
    public PublicacionForo update(Long id ,PublicacionForo request) {
       Set<ConstraintViolation<PublicacionForo>> violations = validator.validate(request);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return pubForoRepository.findById(id).map( pub ->
                        pubForoRepository.save(
                                pub.withName(request.getName())
                                        .withDescription(request.getDescription())
                                        .withActive(request.getActive())
                        ))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, request.getId()));
    }

    @Override
    public ResponseEntity<?> delete(Long PublicacionForoId) {
        return pubForoRepository.findById(PublicacionForoId).map( pub -> {
            pubForoRepository.delete(pub);
            return ResponseEntity.ok().build();
        }).orElseThrow((() -> new ResourceNotFoundException(ENTITY, PublicacionForoId)));
    }
}
