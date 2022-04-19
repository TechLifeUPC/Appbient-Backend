package com.example.appbient.api.mapping;

import com.example.appbient.api.domain.model.entity.Local;
import com.example.appbient.api.resource.Local.CreateLocalResource;
import com.example.appbient.api.resource.Local.LocalResource;
import com.example.appbient.api.resource.Local.UpdateLocalResource;
import com.example.appbient.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class LocalMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public LocalResource toResource(Local local) {
        return mapper.map(local, LocalResource.class);
    }

    public Page<LocalResource> modelListToPage(List<Local> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, LocalResource.class), pageable, modelList.size());
    }

    public Local toModel(CreateLocalResource LocalResource) {
        return mapper.map(LocalResource, Local.class);
    }

    public Local toModel(UpdateLocalResource LocalResource) {
        return mapper.map(LocalResource, Local.class);
    }

}
