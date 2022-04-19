package com.example.appbient.api.controllers;

import com.example.appbient.api.domain.service.ComentarioForoService;
import com.example.appbient.api.mapping.ComentarioForoMapper;
import com.example.appbient.api.resource.ComentarioForo.ComentarioForoResource;
import com.example.appbient.api.resource.ComentarioForo.CreateComentarioForoResource;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/publicacion/{id}/comentarios")
@Api(tags = "Comentario")
public class ComentarioForoController {
    @Autowired
    private ComentarioForoService comentarioForoService;
    @Autowired
    private ComentarioForoMapper mapper;

    @GetMapping
    public Page<ComentarioForoResource> getAllComentariosEnPublicacion(@PathVariable Long id, Pageable pageable){
        return mapper.modelListToPage(comentarioForoService.findByForoId(id), pageable);
    }

    @PostMapping
    public ComentarioForoResource createComentario(@RequestBody CreateComentarioForoResource resource){
        return mapper.toResource(comentarioForoService.create(resource));
    }
    
    @DeleteMapping("/{id}")
    public void deleteComentario(@PathVariable Long id){
        comentarioForoService.delete(id);
    }

}
