package com.example.appbient.api.controllers;

import com.example.appbient.api.domain.service.TopicoService;
import com.example.appbient.api.mapping.TopicoMapper;
import com.example.appbient.api.resource.Topico.CreateTopicoResource;
import com.example.appbient.api.resource.Topico.UpdateTopicoResource;
import com.example.appbient.api.resource.Topico.TopicoResource;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/topico")
@Api(tags = "Topico")
public class TopicoController {
    @Autowired
    private TopicoService TopicoService;

    @Autowired
    private TopicoMapper mapper;

    @GetMapping
    public Page<TopicoResource> getAllTopicos(Pageable pageable){
        return mapper.modelListToPage(TopicoService.getAll(), pageable);
    }

    @GetMapping("/{id}")
    public TopicoResource getTopicoById(@PathVariable Long id){
        return mapper.toResource(TopicoService.getById(id));
    }

    @PostMapping
    public TopicoResource createTopico(@RequestBody CreateTopicoResource resource){
        return mapper.toResource(TopicoService.create(mapper.toModel(resource)));
    }

    @PutMapping("/{id}")
    public TopicoResource updateTopico(@PathVariable Long id ,@RequestBody UpdateTopicoResource resource){
        return mapper.toResource(TopicoService.update(id,mapper.toModel(resource)));
    }

    @DeleteMapping("/{id}")
    public void deleteTopico(@PathVariable Long id){
        TopicoService.delete(id);
    }
}
