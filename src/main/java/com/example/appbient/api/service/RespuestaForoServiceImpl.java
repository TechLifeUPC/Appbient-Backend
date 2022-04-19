package com.example.appbient.api.service;

import com.example.appbient.api.domain.model.entity.ComentariosForo;
import com.example.appbient.api.domain.model.entity.RespuestaForo;
import com.example.appbient.api.domain.model.entity.PublicacionForo;
import com.example.appbient.api.domain.model.entity.RespuestaForo;
import com.example.appbient.api.domain.persistence.ComentarioForoRepository;
import com.example.appbient.api.domain.persistence.RespuestaForoRepository;
import com.example.appbient.api.domain.service.RespuestaForoService;
import com.example.appbient.api.resource.RespuestaForo.CreateRespuestaForoResource;
import com.example.appbient.api.resource.RespuestaForo.RespuestaForoResource;
import com.example.appbient.shared.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespuestaForoServiceImpl implements RespuestaForoService {
    private static final String ENTITY = "RespuestaForo";

    private final RespuestaForoRepository respuestaForoRepository;
    private final ComentarioForoRepository comentarioForoRepository;

    public RespuestaForoServiceImpl(RespuestaForoRepository respuestaForoRepository, ComentarioForoRepository comentarioForoRepository) {
        this.respuestaForoRepository = respuestaForoRepository;
        this.comentarioForoRepository = comentarioForoRepository;
    }

    @Override
    public List<RespuestaForo> findByComentario(Long ComentarioId) {
        return respuestaForoRepository.findByComentarioId(ComentarioId);
    }

    @Override
    public RespuestaForo create(Long comentarioId,CreateRespuestaForoResource request) {
        ComentariosForo comentario = comentarioForoRepository.findById(comentarioId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, comentarioId));
        RespuestaForo respuesta = new RespuestaForo();
        respuesta.setDescripcion(request.getDescripcion());
        respuesta.setComentario(comentario);
        return respuestaForoRepository.save(respuesta);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return respuestaForoRepository.findById(id).map(respuestaForo -> {
            respuestaForoRepository.delete(respuestaForo);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

}
