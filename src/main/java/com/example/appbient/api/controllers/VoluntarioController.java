package com.example.appbient.api.controllers;

import com.example.appbient.api.domain.service.VoluntarioService;
import com.example.appbient.api.mapping.VoluntarioMapper;
import com.example.appbient.api.resource.Voluntario.CreateVoluntarioResource;
import com.example.appbient.api.resource.Voluntario.UpdateVoluntarioResource;
import com.example.appbient.api.resource.Voluntario.VoluntarioResource;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/voluntario")
@Api(tags = "Voluntario")
public class VoluntarioController {
    @Autowired
    private VoluntarioService voluntarioService;

    @Autowired
    private VoluntarioMapper mapper;

    @GetMapping
    public Page<VoluntarioResource> getAllVoluntarios(Pageable pageable){
        return mapper.modelListToPage(voluntarioService.getAll(), pageable);
    }

    @GetMapping("/{id}")
    public VoluntarioResource getVoluntarioById(@PathVariable Long id){
        return mapper.toResource(voluntarioService.getById(id));
    }

    @PostMapping
    public VoluntarioResource createVoluntario(@RequestBody CreateVoluntarioResource resource){
        return mapper.toResource(voluntarioService.create(mapper.toModel(resource)));
    }

    @PutMapping("/{id}")
    public VoluntarioResource updateVoluntario(@PathVariable Long id ,@RequestBody UpdateVoluntarioResource resource){
        return mapper.toResource(voluntarioService.update(id,mapper.toModel(resource)));
    }

    @DeleteMapping("/{id}")
    public void deleteVoluntario(@PathVariable Long id){
        voluntarioService.delete(id);
    }
}
