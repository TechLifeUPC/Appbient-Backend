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
@RequestMapping("/api/v1/publicacion/{publicacionId}/comentarios")
@Api(tags = "ComentarioForo")
public class ComentarioForoController {
    @Autowired
    private ComentarioForoService comentarioForoService;
    @Autowired
    private ComentarioForoMapper mapper;

    @GetMapping
    public Page<ComentarioForoResource> getAllComentariosEnPublicacion(@PathVariable Long publicacionId, Pageable pageable){
        return mapper.modelListToPage(comentarioForoService.findByForoId(publicacionId), pageable);
    }

    @PostMapping
    public ComentarioForoResource createComentario(@PathVariable Long publicacionId,@RequestBody CreateComentarioForoResource resource){
        return mapper.toResource(comentarioForoService.create(publicacionId,resource));
    }

    @DeleteMapping("/{id}")
    public void deleteComentario(@PathVariable Long id){
        comentarioForoService.delete(id);
    }

}
