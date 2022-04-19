package com.example.appbient.api.mapping;

import com.example.appbient.api.domain.model.entity.RespuestaForo;
import com.example.appbient.api.resource.RespuestaForo.CreateRespuestaForoResource;
import com.example.appbient.api.resource.RespuestaForo.RespuestaForoResource;
import com.example.appbient.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class RespuestaForoMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public RespuestaForoResource toResource(RespuestaForo RespuestaForo) {
        return mapper.map(RespuestaForo, RespuestaForoResource.class);
    }

    public Page<RespuestaForoResource> modelListToPage(List<RespuestaForo> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, RespuestaForoResource.class), pageable, modelList.size());
    }

    public RespuestaForo toModel(CreateRespuestaForoResource RespuestaForoResource) {
        return mapper.map(RespuestaForoResource, RespuestaForo.class);
    }
}
