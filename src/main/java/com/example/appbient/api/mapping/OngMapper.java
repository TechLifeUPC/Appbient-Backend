package com.example.appbient.api.mapping;

import com.example.appbient.api.domain.model.entity.Ong;
import com.example.appbient.api.resource.Ong.CreateOngResource;
import com.example.appbient.api.resource.Ong.OngResource;
import com.example.appbient.api.resource.Ong.UpdateOngResource;
import com.example.appbient.api.resource.Ong.CreateOngResource;
import com.example.appbient.api.resource.Ong.UpdateOngResource;
import com.example.appbient.api.resource.Ong.OngResource;
import com.example.appbient.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class OngMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public OngResource toResource(Ong ong) {
        return mapper.map(ong, OngResource.class);
    }

    public Page<OngResource> modelListToPage(List<Ong> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, OngResource.class), pageable, modelList.size());
    }

    public Ong toModel(CreateOngResource OngResource) {
        return mapper.map(OngResource, Ong.class);
    }

    public Ong toModel(UpdateOngResource OngResource) {
        return mapper.map(OngResource, Ong.class);
    }

}
