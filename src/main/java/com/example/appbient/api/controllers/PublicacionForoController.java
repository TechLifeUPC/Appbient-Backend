package com.example.appbient.api.controllers;

import com.example.appbient.api.domain.service.PublicacionForoService;
import com.example.appbient.api.mapping.PublicacionForoMapper;
import com.example.appbient.api.resource.PublicacionForo.CreatePublicacionForoResource;
import com.example.appbient.api.resource.PublicacionForo.UpdatePublicacionForoResource;
import com.example.appbient.api.resource.PublicacionForo.PublicacionForoResource;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/publicacion")
@Api(tags = "Publicaciones")
public class PublicacionForoController {
    @Autowired
    private PublicacionForoService PublicacionForoService;

    @Autowired
    private PublicacionForoMapper mapper;

    @GetMapping
    public Page<PublicacionForoResource> getAllPublicacionForos(Pageable pageable){
        return mapper.modelListToPage(PublicacionForoService.getAll(), pageable);
    }

    @GetMapping("/{id}")
    public PublicacionForoResource getPublicacionForoById(@PathVariable Long id){
        return mapper.toResource(PublicacionForoService.getById(id));
    }

    @PostMapping
    public PublicacionForoResource createPublicacionForo(@RequestBody CreatePublicacionForoResource resource){
        return mapper.toResource(PublicacionForoService.create(resource));
    }

    @PutMapping("/{id}")
    public PublicacionForoResource updatePublicacionForo(@PathVariable Long id ,@RequestBody UpdatePublicacionForoResource resource){
        return mapper.toResource(PublicacionForoService.update(id,mapper.toModel(resource)));
    }

    @DeleteMapping("/{id}")
    public void deletePublicacionForo(@PathVariable Long id){
        PublicacionForoService.delete(id);
    }
}
