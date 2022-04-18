package com.example.appbient.api.mapping;

import com.example.appbient.api.domain.model.entity.Topico;
import com.example.appbient.api.domain.model.entity.Topico;
import com.example.appbient.api.resource.Topico.CreateTopicoResource;
import com.example.appbient.api.resource.Topico.TopicoResource;
import com.example.appbient.api.resource.Topico.UpdateTopicoResource;
import com.example.appbient.api.resource.Topico.TopicoResource;
import com.example.appbient.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class TopicoMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public TopicoResource toResource(Topico topico) {
        return mapper.map(topico, TopicoResource.class);
    }

    public Topico toModel(CreateTopicoResource topicoResource) {
        return mapper.map(topicoResource, Topico.class);
    }

    public Page<TopicoResource> modelListToPage(List<Topico> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, TopicoResource.class), pageable, modelList.size());
    }

    public Topico toModel(UpdateTopicoResource topicoResource) {
        return mapper.map(topicoResource, Topico.class);
    }

}
