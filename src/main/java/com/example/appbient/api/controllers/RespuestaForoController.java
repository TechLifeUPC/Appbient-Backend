package com.example.appbient.api.controllers;

import com.example.appbient.api.domain.service.RespuestaForoService;
import com.example.appbient.api.mapping.RespuestaForoMapper;
import com.example.appbient.api.resource.RespuestaForo.CreateRespuestaForoResource;
import com.example.appbient.api.resource.RespuestaForo.RespuestaForoResource;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/publicacion/{idPublicacion}/comentarios/{idComentario}/respuestas")
@Api(tags = "RespuestaForo")
public class RespuestaForoController {
    @Autowired
    private RespuestaForoService respuestaForoService;
    @Autowired
    private RespuestaForoMapper mapper;

    @GetMapping
    public Page<RespuestaForoResource> getAllRespuestasEnComentario(@PathVariable Long idComentario, Pageable pageable){
        return mapper.modelListToPage(respuestaForoService.findByComentario(idComentario), pageable);
    }

    @PostMapping
    public RespuestaForoResource createComentario(@PathVariable Long idComentario,@RequestBody CreateRespuestaForoResource resource){
        return mapper.toResource(respuestaForoService.create(idComentario,resource));
    }
    
    @DeleteMapping("/{id}")
    public void deleteComentario(@PathVariable Long id){
        respuestaForoService.delete(id);
    }

}
