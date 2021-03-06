package com.example.appbient.api.service;

import com.example.appbient.api.domain.model.entity.ComentariosForo;
import com.example.appbient.api.domain.model.entity.PublicacionForo;
import com.example.appbient.api.domain.persistence.ComentarioForoRepository;
import com.example.appbient.api.domain.persistence.PublicacionForoRepository;
import com.example.appbient.api.domain.service.ComentarioForoService;
import com.example.appbient.api.resource.ComentarioForo.ComentarioForoResource;
import com.example.appbient.api.resource.ComentarioForo.CreateComentarioForoResource;
import com.example.appbient.shared.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class ComentarioForoServiceImpl implements ComentarioForoService {
    private static final String ENTITY = "ComentarioForo";

    private final ComentarioForoRepository comentarioRepository;
    private final PublicacionForoRepository publicacionRepository;

    public ComentarioForoServiceImpl(ComentarioForoRepository comentarioRepository, PublicacionForoRepository publicacionRepository) {
        this.comentarioRepository = comentarioRepository;
        this.publicacionRepository = publicacionRepository;
    }

    @Override
    public List<ComentariosForo> findByForoId(Long foroId) {   return comentarioRepository.findByPublicacionId(foroId);    }

    @Override
    public ComentariosForo create(Long foroId,CreateComentarioForoResource request) {
        PublicacionForo publicacion = publicacionRepository.findById(foroId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, foroId));
        ComentariosForo comentario = new ComentariosForo();
            comentario.setDescripcion(request.getDescripcion());
            comentario.setPublicacion(publicacion);
        return comentarioRepository.save(comentario);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return comentarioRepository.findById(id).map(comentario -> {
            comentarioRepository.delete(comentario);
            return ResponseEntity.ok().build();
        }).orElseThrow((() -> new ResourceNotFoundException(ENTITY, id)));
    }
}
