package com.example.appbient.api.mapping;

import com.example.appbient.api.resource.Voluntario.UpdateVoluntarioResource;
import com.example.appbient.api.domain.model.entity.Voluntario;
import com.example.appbient.api.resource.Voluntario.CreateVoluntarioResource;
import com.example.appbient.api.resource.Voluntario.VoluntarioResource;
import com.example.appbient.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.List;

public class VoluntarioMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public VoluntarioResource toResource(Voluntario Voluntario) {
        return mapper.map(Voluntario, VoluntarioResource.class);
    }

    public Page<VoluntarioResource> modelListToPage(List<Voluntario> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, VoluntarioResource.class), pageable, modelList.size());
    }

    public Voluntario toModel(CreateVoluntarioResource VoluntarioResource) {
        return mapper.map(VoluntarioResource, Voluntario.class);
    }

    public Voluntario toModel(UpdateVoluntarioResource VoluntarioResource) {
        return mapper.map(VoluntarioResource, Voluntario.class);
    }

}
