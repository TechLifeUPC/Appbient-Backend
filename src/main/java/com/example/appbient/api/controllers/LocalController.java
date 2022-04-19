package com.example.appbient.api.controllers;

import com.example.appbient.api.domain.service.LocalService;
import com.example.appbient.api.mapping.LocalMapper;
import com.example.appbient.api.resource.Local.CreateLocalResource;
import com.example.appbient.api.resource.Local.LocalResource;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ong/{ongId}/local")
@Api(tags = "Local")
public class LocalController {
    @Autowired
    private LocalService localService;
    @Autowired
    private LocalMapper mapper;

    @GetMapping
    public Page<LocalResource> getAllLocals(@PathVariable Long ongId, Pageable pageable) {
        return mapper.modelListToPage(localService.getByOngId(ongId), pageable);
    }

    @PostMapping
    public LocalResource createLocal(@PathVariable Long ongId,@RequestBody CreateLocalResource request) {
        return mapper.toResource(localService.create(ongId,mapper.toModel(request)));
    }

    @PutMapping("/{localId}")
    public LocalResource updateLocal(@PathVariable Long localId, @RequestBody CreateLocalResource request) {
        return mapper.toResource(localService.update(localId, mapper.toModel(request)));
    }

    @DeleteMapping("/{localId}")
    public void deleteLocal(@PathVariable Long localId) {
        localService.delete(localId);
    }
}
