package com.example.appbient.api.resource.Topico;

import javax.validation.constraints.Size;

import lombok.*;

@Getter
@Setter
public class TopicoResource {
    private Long id;
    private String name;
    private String description;
}
